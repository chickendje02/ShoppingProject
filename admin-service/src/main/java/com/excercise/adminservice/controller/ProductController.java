package com.excercise.adminservice.controller;

import com.excercise.adminservice.model.dto.ProductDTO;
import com.excercise.adminservice.model.filter.ProductFilter;
import com.excercise.adminservice.model.update.ProductUpdateModel;
import com.excercise.adminservice.proxy.ProductProxy;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/admin/product")
public class ProductController {

    @Autowired
    ProductProxy productProxy;

    @GetMapping("/find-all")
    public List<ProductDTO> findAll(ProductFilter filter) {
        return productProxy.findAll(filter.getName(), filter.getPrice(), filter.getVendorId(), filter.getPageNumber(), filter.getPageSize());
    }

    @GetMapping("/get-product-detail/{id}")
    public ResponseEntity getProductDetail(@PathVariable Long id) {
        return productProxy.getProductDetail(id);
    }

    @PostMapping
    public ResponseEntity addProduct(@RequestBody ProductUpdateModel product) {
        return productProxy.addProduct(product);
    }

    @PutMapping
    public ResponseEntity updateProduct(@RequestBody ProductUpdateModel product) {
        return productProxy.updateProduct(product);
    }

    @DeleteMapping("/delete-product/{id}")
    public ResponseEntity removeProduct(@PathVariable Long id) {
        return productProxy.removeProduct(id);
    }
}
