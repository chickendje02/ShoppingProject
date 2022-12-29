package com.excercise.productservice.service.impl;

import com.excercise.productservice.enumeration.ActionType;
import com.excercise.productservice.enumeration.TypeImage;
import com.excercise.productservice.exception.CommonBusinessException;
import com.excercise.productservice.model.dto.ImageDTO;
import com.excercise.productservice.model.dto.ProductDTO;
import com.excercise.productservice.model.filter.ProductFilter;
import com.excercise.productservice.model.orm.Image;
import com.excercise.productservice.model.orm.Product;
import com.excercise.productservice.model.orm.Vendor;
import com.excercise.productservice.model.update.LogUpdateModel;
import com.excercise.productservice.model.update.ProductUpdate;
import com.excercise.productservice.repository.ImageRepository;
import com.excercise.productservice.repository.ProductRepository;
import com.excercise.productservice.repository.VendorRepository;
import com.excercise.productservice.service.LogService;
import com.excercise.productservice.service.ProductService;
import com.excercise.productservice.utils.UtilFunction;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    ProductRepository productRepository;

    ImageRepository imageRepository;

    LogService logService;

    VendorRepository vendorRepository;

    public ProductServiceImpl(ProductRepository productRepository, ImageRepository imageRepository, LogService logService, VendorRepository vendorRepository) {
        this.productRepository = productRepository;
        this.imageRepository = imageRepository;
        this.logService = logService;
        this.vendorRepository = vendorRepository;
    }

    @Override
    public List<ProductDTO> findAll(ProductFilter filter) {
        List<ProductDTO> result = new ArrayList<>();
        Optional<Vendor> vendor = vendorRepository.findById(filter.getVendorId());
        if (vendor.isEmpty()) {
            throw new CommonBusinessException("Invalid Vendor");
        }
        Optional<List<Product>> products = productRepository.findAllByProductNameContainsAndVendorIdAndProductPriceLessThan(filter.getName(), filter.getVendorId(), filter.getPrice());
        products.ifPresent(productList -> productList.forEach(product -> {
            List<Image> images = imageRepository.findAllByProductId(product.getId());
            result.add(this.mappingToProduct(product, vendor.get().getVendorName(), images));
        }));
        LogUpdateModel logUpdateModel = this.prepareLogModelData(ActionType.SEARCH, UtilFunction.convertToJson(filter));
        logService.saveLog(logUpdateModel);
        return result;
    }


    @Override
    public ProductDTO getProductDetail(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            LogUpdateModel logUpdateModel = this.prepareLogModelData(ActionType.SEARCH, UtilFunction.convertToJson(product.get()));
            logService.saveLog(logUpdateModel);
            Optional<Vendor> vendor = vendorRepository.findById(product.get().getVendorId());
            List<Image> images = imageRepository.findAllByProductId(product.get().getId());
            return this.mappingToProduct(product.get(), vendor.get().getVendorName(),images);
        }
        throw new CommonBusinessException("Not found Product", HttpStatus.NOT_FOUND.value());
    }

    @Override
    @Transactional
    public void removeProduct(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
//            Set<Image> images = product.get().getImages();
//            if (!images.isEmpty()) {
//                imageRepository.deleteByProductId(id);
//            }
            productRepository.deleteById(id);
        } else {
            throw new CommonBusinessException("Not found Product", HttpStatus.NOT_FOUND.value());
        }
    }

    @Override
    @Transactional
    public void saveProduct(ProductUpdate product) {
        Vendor vendor = new Vendor();
        vendor.setId(product.getVendorId());
        Product model = Product.builder()
                .id(product.getId())
                .productName(product.getProductName())
                .productPrice(product.getProductPrice())
                .typeId(product.getTypeId())
                .lastUpdateBy(StringUtils.EMPTY)
                .build();
        Product savedProduct = productRepository.save(model);
        if (!product.getImageUpdate().isEmpty()) {
            List<Image> list = product.getImageUpdate().stream().map(image -> image.buildModelCreate(image, savedProduct.getId())).collect(Collectors.toList());
            imageRepository.saveAll(list);
        }
    }

    private ProductDTO mappingToProduct(Product product, String vendorName, List<Image> images) {
        List<ImageDTO> imageDTOList = images.stream().map(this::mappingToImage).collect(Collectors.toList());
        return ProductDTO.builder()
                .id(product.getId())
                .productName(product.getProductName())
                .typeId(product.getTypeId())
                .listImages(imageDTOList)
                .vendorName(vendorName)
                .build();
    }

    private ImageDTO mappingToImage(Image image) {
        return ImageDTO.builder()
                .imageName(image.getImageName())
                .typeImage(TypeImage.valueOf(image.getTypeImage()))
                .build();
    }

    private LogUpdateModel prepareLogModelData(ActionType actionType, String content) {
        return LogUpdateModel.builder()
                .actionType(actionType)
                .content(content)
                .build();
    }

}
