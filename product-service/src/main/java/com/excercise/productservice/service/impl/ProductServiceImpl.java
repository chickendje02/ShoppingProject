package com.excercise.productservice.service.impl;

import com.excercise.productservice.model.Product;
import com.excercise.productservice.model.ProductFilter;
import com.excercise.productservice.repository.ProductRepository;
import com.excercise.productservice.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll(ProductFilter filter){
        List<Product> result = new ArrayList<>();
        Optional<List<Product>> products =  productRepository.findAllByProductNameContainsAndVendorsVendorNameContains(filter.getName(), filter.getVendorName());
        if(products.isPresent()){
            result = products.get();
        }
        return result;
    }
}
