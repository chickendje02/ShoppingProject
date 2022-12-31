package com.excercise.productservice.controller;

import com.excercise.productservice.model.dto.ProductDTO;
import com.excercise.productservice.model.filter.ProductFilter;
import com.excercise.productservice.model.update.ProductUpdateModel;
import com.excercise.productservice.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public List<ProductDTO> findAll(ProductFilter filter) {
        return productService.findAll(filter);
    }

    @GetMapping("/get-product-detail/{id}")
    public ResponseEntity getProductDetail(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProductDetail(id));
    }

    @PostMapping
    public ResponseEntity addProduct(@RequestBody ProductUpdateModel product) {
        productService.saveProduct(product);
        return ResponseEntity.ok("Ok");
    }

    @PutMapping
    public ResponseEntity updateProduct(@RequestBody ProductUpdateModel product) {
        productService.saveProduct(product);
        return ResponseEntity.ok("Ok");
    }

    @DeleteMapping("/delete-product/{id}")
    public ResponseEntity removeProduct(@PathVariable Long id) {
        productService.removeProduct(id);
        return ResponseEntity.ok("Ok");
    }
}
