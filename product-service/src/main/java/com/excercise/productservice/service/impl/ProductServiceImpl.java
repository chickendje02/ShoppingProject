package com.excercise.productservice.service.impl;

import com.excercise.productservice.enumeration.TypeImage;
import com.excercise.productservice.model.dto.ImageDTO;
import com.excercise.productservice.model.dto.ProductDTO;
import com.excercise.productservice.model.filter.ProductFilter;
import com.excercise.productservice.model.orm.Image;
import com.excercise.productservice.model.orm.Product;
import com.excercise.productservice.model.orm.Vendor;
import com.excercise.productservice.model.update.ProductUpdate;
import com.excercise.productservice.repository.ImageRepository;
import com.excercise.productservice.repository.ProductRepository;
import com.excercise.productservice.service.ProductService;
import org.apache.commons.lang3.StringUtils;
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

    public ProductServiceImpl(ProductRepository productRepository, ImageRepository imageRepository) {
        this.productRepository = productRepository;
        this.imageRepository = imageRepository;
    }

    @Override
    public List<ProductDTO> findAll(ProductFilter filter) {
        List<ProductDTO> result = new ArrayList<>();
        Optional<List<Product>> products = Optional.of(productRepository.findAll());
//        Optional<List<Product>> products =  productRepository.findAllByProductNameContainsAndProductPriceLessThanAndVendorVendorNameContains(filter.getName(), filter.getPrice(),filter.getVendorName());
        if (products.isPresent()) {
            products.get().forEach(product -> {
                result.add(this.mappingToProduct(product));
            });
        }
        return result;
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
                .vendor(vendor)
                .lastUpdateBy(StringUtils.EMPTY)
                .build();
//        product.getImages().forEach(image -> image.setProduct(product));
        Product savedProduct = productRepository.save(model);
        if (!product.getImageUpdate().isEmpty()) {
            List<Image> list = product.getImageUpdate().stream().map(image -> image.buildModelCreate(image, savedProduct)).collect(Collectors.toList());
            imageRepository.saveAll(list);
        }
    }

    private ProductDTO mappingToProduct(Product product) {
        List<ImageDTO> imageDTOS = product.getImages().stream().map(this::mappingToImage).collect(Collectors.toList());
        return ProductDTO.builder()
                .id(product.getId())
                .productName(product.getProductName())
                .typeId(product.getTypeId())
                .listImages(imageDTOS)
                .vendorName(product.getVendor().getVendorName())
                .build();
    }

    private ImageDTO mappingToImage(Image image) {
        return ImageDTO.builder()
                .imageName(image.getImageName())
                .typeImage(TypeImage.valueOf(image.getTypeImage()))
                .build();
    }

}
