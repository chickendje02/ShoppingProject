package com.excercise.productservice.service.impl;

import com.excercise.productservice.cache.CacheModel;
import com.excercise.productservice.cache.ProductCache;
import com.excercise.productservice.enumeration.TypeImage;
import com.excercise.productservice.exception.CommonBusinessException;
import com.excercise.productservice.model.dto.ImageDTO;
import com.excercise.productservice.model.dto.ProductDTO;
import com.excercise.productservice.model.filter.ProductFilter;
import com.excercise.productservice.model.orm.Image;
import com.excercise.productservice.model.orm.Product;
import com.excercise.productservice.model.orm.TypeProduct;
import com.excercise.productservice.model.orm.Vendor;
import com.excercise.productservice.model.update.ProductUpdateModel;
import com.excercise.productservice.repository.ImageRepository;
import com.excercise.productservice.repository.ProductRepository;
import com.excercise.productservice.repository.TypeProductRepository;
import com.excercise.productservice.repository.VendorRepository;
import com.excercise.productservice.service.ProductService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private static final Long TIME_EXPIRED = 600000L;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ImageRepository imageRepository;

    @Autowired
    VendorRepository vendorRepository;

    @Autowired
    TypeProductRepository typeProductRepository;

    @Override
    public List<ProductDTO> findAll(ProductFilter filter) {
        List<ProductDTO> result = new ArrayList<>();
        CacheModel<List<ProductDTO>> dataCache = ProductCache.getData(filter.toString());
        if (Objects.nonNull(dataCache)) {
            return dataCache.getData();
        }
        Optional<Vendor> vendor = Optional.empty();
        boolean isFilteredByVendor = Objects.nonNull(filter.getVendorId()) && filter.getVendorId() > 0;
        boolean isFilteredByProductPrice = Objects.nonNull(filter.getPrice()) && filter.getPrice().compareTo(BigDecimal.ZERO) > 0;
        if (isFilteredByVendor) {
            vendor = vendorRepository.findById(filter.getVendorId());
            if (vendor.isEmpty()) {
                throw new CommonBusinessException("Invalid Vendor");
            }
        }
        Pageable pageRequest = PageRequest.of(filter.getPageNumber(), filter.getPageSize());
        Optional<List<Product>> products;
        if (isFilteredByVendor && isFilteredByProductPrice) {
            products = productRepository.findAllByProductNameContainsAndVendorIdAndProductPriceLessThan(filter.getName(), filter.getVendorId(), filter.getPrice(), pageRequest);
        } else if (isFilteredByVendor) {
            products = productRepository.findAllByProductNameContainsAndVendorId(filter.getName(), filter.getVendorId(), pageRequest);
        } else if (isFilteredByProductPrice) {
            products = productRepository.findAllByProductNameContainsAndProductPriceLessThan(filter.getName(), filter.getPrice(), pageRequest);
        } else {
            products = productRepository.findAllByProductNameContains(filter.getName(), pageRequest);
        }
        products.ifPresent(productList -> productList.forEach(product -> {
            result.add(this.mappingToProduct(product));
        }));
        ProductCache.putData(filter.toString(), result, TIME_EXPIRED);
        return result;
    }

    @Override
    public ProductDTO findByTypeId(Long typeId) {
        Optional<Product> product = productRepository.findByTypeId(typeId);
        ProductDTO productDTO = null;
        if (product.isPresent()) {
            productDTO = this.mappingToProduct(product.get());
        }
        return productDTO;
    }

    @Override
    public ProductDTO findByVendorId(Long vendorId) {
        Optional<Product> product = productRepository.findByVendorId(vendorId);
        ProductDTO productDTO = null;
        if (product.isPresent()) {
            productDTO = this.mappingToProduct(product.get());
        }
        return productDTO;
    }

    @Override
    public ProductDTO getProductDetail(Long id) {
        String cacheKey = "product:" + id;
        CacheModel<ProductDTO> dataCache = ProductCache.getData(cacheKey);
        if (Objects.nonNull(dataCache)) {
            return dataCache.getData();
        }
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            ProductDTO result = this.mappingToProduct(product.get());
            ProductCache.putData(cacheKey, result, TIME_EXPIRED);
            return result;
        }
        throw new CommonBusinessException("Not found Product", HttpStatus.NOT_FOUND.value());
    }

    @Override
    @Transactional
    public void removeProduct(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            imageRepository.deleteAllByProductId(id);
            productRepository.deleteById(id);
            String cacheKey = "product:" + id;
            CacheModel<ProductDTO> dataCache = ProductCache.getData(cacheKey);
            if (Objects.nonNull(dataCache)) {
                ProductCache.removeData(cacheKey);
            }
        } else {
            throw new CommonBusinessException("Not found Product", HttpStatus.NOT_FOUND.value());
        }
    }

    @Override
    @Transactional
    public void saveProduct(ProductUpdateModel product) {
        this.validation(product);
        List<Image> listImages = new ArrayList<>();
        Product model = this.markupData(product);
        Product savedProduct = productRepository.save(model);
        if (!product.getImageUpdate().isEmpty()) {
            List<Image> list = product.getImageUpdate().stream().map(image -> image.buildModelCreate(image, savedProduct.getId())).collect(Collectors.toList());
            listImages = imageRepository.saveAll(list);
        }
        String cacheKey = "product:" + savedProduct.getId();
        CacheModel<ProductDTO> dataCache = ProductCache.getData(cacheKey);
        if (Objects.nonNull(dataCache)) {
            ProductDTO productData = this.mappingToProduct(savedProduct);
            ProductCache.updateData(cacheKey, productData);
        }
    }

    private ProductDTO mappingToProduct(Product product) {
        List<Image> images = imageRepository.findAllByProductId(product.getId());
        List<ImageDTO> imageDTOList = images.stream().map(this::mappingToImage).collect(Collectors.toList());
        return ProductDTO.builder()
                .id(product.getId())
                .productName(product.getProductName())
                .productPrice(product.getProductPrice())
                .typeId(product.getTypeId())
                .listImages(imageDTOList)
                .vendorId(product.getVendorId())
//                .vendorName(vendorName)
                .build();
    }

    private ImageDTO mappingToImage(Image image) {
        return ImageDTO.builder()
                .imageName(image.getImageName())
                .typeImage(TypeImage.valueOf(image.getTypeImage()))
                .build();
    }

    private void validation(ProductUpdateModel model) {
        if (StringUtils.isEmpty(model.getProductName())) {
            throw new CommonBusinessException("Product Name can not be empited");
        }
        if (Objects.isNull(model.getProductPrice()) || model.getProductPrice().compareTo(BigDecimal.ONE) == 0) {
            throw new CommonBusinessException("Product Price need to be higher than 0");
        }
        if (Objects.isNull(model.getProductQuantity()) || model.getProductQuantity() == 0) {
            throw new CommonBusinessException("Product Quantity need to be higher than 0");
        }
        Optional<Vendor> vendor = vendorRepository.findById(model.getVendorId());
        if (vendor.isEmpty()) {
            throw new CommonBusinessException("Vendor is not existed");
        }
        Optional<TypeProduct> typeProduct = typeProductRepository.findById(model.getTypeId());
        if (typeProduct.isEmpty()) {
            throw new CommonBusinessException("Type Product is not existed");
        }

        List<Product> data = productRepository.findAll();
        data.stream().parallel().forEach(item -> {
            if (item.getProductName().equalsIgnoreCase(model.getProductName()) && !Objects.equals(model.getId(), item.getId())) {
                throw new CommonBusinessException("Product Name is existed");
            }
        });
    }

    private Product markupData(ProductUpdateModel product) {
        return Product.builder()
                .id(product.getId())
                .productName(product.getProductName())
                .productPrice(product.getProductPrice())
                .typeId(product.getTypeId())
                .lastUpdateBy(StringUtils.EMPTY)
                .vendorId(product.getVendorId())
                .typeId(product.getTypeId())
                .build();
    }
}
