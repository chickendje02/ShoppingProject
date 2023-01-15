package com.excercise.productservice.controller;

import com.excercise.productservice.enumeration.ActionType;
import com.excercise.productservice.model.dto.ProductDTO;
import com.excercise.productservice.model.filter.ProductFilter;
import com.excercise.productservice.model.update.LogUpdateModel;
import com.excercise.productservice.model.update.ProductUpdateModel;
import com.excercise.productservice.service.LogService;
import com.excercise.productservice.service.ProductService;
import com.excercise.productservice.utils.UtilFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    LogService logService;

    @GetMapping("/find-all")
    public List<ProductDTO> findAll(ProductFilter filter) {
        // Insert Log
        LogUpdateModel logUpdateModel = LogUpdateModel.prepareLogModelData(ActionType.SEARCH, UtilFunction.convertToJson(filter));
        logService.saveLog(logUpdateModel);
        return productService.findAll(filter);
    }

    @GetMapping("/get-product-detail/{id}")
    public ResponseEntity getProductDetail(@PathVariable Long id) {
        LogUpdateModel logUpdateModel = LogUpdateModel.prepareLogModelData(ActionType.VIEW, UtilFunction.convertToJson(id));
        logService.saveLog(logUpdateModel);
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
