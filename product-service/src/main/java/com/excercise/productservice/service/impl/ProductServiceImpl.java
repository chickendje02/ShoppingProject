package com.excercise.productservice.service.impl;

import com.excercise.productservice.dto.ImageDTO;
import com.excercise.productservice.dto.ProductDTO;
import com.excercise.productservice.dto.VendorDTO;
import com.excercise.productservice.enumeration.TypeImage;
import com.excercise.productservice.model.Image;
import com.excercise.productservice.model.Product;
import com.excercise.productservice.model.ProductFilter;
import com.excercise.productservice.model.Vendor;
import com.excercise.productservice.repository.ProductRepository;
import com.excercise.productservice.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDTO> findAll(ProductFilter filter){
        List<ProductDTO> result = new ArrayList<>();
        Optional<List<Product>> products = Optional.of(productRepository.findAll());
//        Optional<List<Product>> products =  productRepository.findAllByProductNameContainsAndProductPriceLessThanAndVendorVendorNameContains(filter.getName(), filter.getPrice(),filter.getVendorName());
        if(products.isPresent()){
            products.get().forEach(product -> {
                result.add(this.mappingToProduct(product));
            });
        }
        return result;
    }

    @Override
    public void saveProduct(Product product){
        product.getImages().forEach(image -> image.setProduct(product));
        productRepository.save(product);
    }

    private ProductDTO mappingToProduct(Product product){
        List<ImageDTO> imageDTOS = product.getImages().stream().map(this::mappingToImage).collect(Collectors.toList());
        return ProductDTO.builder()
                .id(product.getId())
                .productName(product.getProductName())
                .typeId(product.getTypeId())
                .listImages(imageDTOS)
                .vendorName(product.getVendor().getVendorName())
                .build();
    }

    private ImageDTO mappingToImage(Image image){
        return ImageDTO.builder()
                .imageName(image.getImageName())
                .typeImage(TypeImage.valueOf(image.getTypeImage()))
                .build();
    }

    private VendorDTO mappingVendor(Vendor vendor){
        return VendorDTO.builder()
                .vendorName(vendor.getVendorName())
                .country(vendor.getCountry())
                .build();
    }
}
