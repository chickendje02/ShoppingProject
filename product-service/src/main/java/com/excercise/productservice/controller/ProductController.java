package com.excercise.productservice.controller;

import com.excercise.productservice.model.dto.ProductDTO;
import com.excercise.productservice.model.update.ProductUpdate;
import com.excercise.productservice.model.filter.ProductFilter;
import com.excercise.productservice.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/find-all")
    public List<ProductDTO> findAll(ProductFilter filter){
        return productService.findAll(filter);
    }

    @PostMapping
    public ResponseEntity addProduct(@RequestBody ProductUpdate product){
        productService.saveProduct(product);
        return ResponseEntity.ok("Ok");
    }

    @PutMapping
    public ResponseEntity updateProduct(@RequestBody ProductUpdate product){
        productService.saveProduct(product);
        return ResponseEntity.ok("Ok");
    }
}
