package com.excercise.productservice.controller;

import com.excercise.productservice.model.Product;
import com.excercise.productservice.model.ProductFilter;
import com.excercise.productservice.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/find-all")
    public List<Product> findAll(ProductFilter filter){
        return productService.findAll(filter);
    }
}
