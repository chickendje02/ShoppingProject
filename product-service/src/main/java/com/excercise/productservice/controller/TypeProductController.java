package com.excercise.productservice.controller;

import com.excercise.productservice.model.update.TypeProductUpdateModel;
import com.excercise.productservice.service.TypeProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/type")
public class TypeProductController {

    @Autowired
    TypeProductService typeProductService;

    @GetMapping
    public ResponseEntity getListTypeProduct() {
        return ResponseEntity.ok(typeProductService.findAll());
    }

    @PostMapping
    public ResponseEntity saveTypeProduct(@RequestBody TypeProductUpdateModel model) {
        typeProductService.addOrUpdateTypeProduct(model);
        return ResponseEntity.ok("Ok");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTypeProduct(@PathVariable Long id) {
        typeProductService.deleteTypeProduct(id);
        return ResponseEntity.ok("Ok");
    }
}
