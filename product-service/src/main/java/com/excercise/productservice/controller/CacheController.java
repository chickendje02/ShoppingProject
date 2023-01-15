package com.excercise.productservice.controller;

import com.excercise.productservice.cache.CacheModel;
import com.excercise.productservice.cache.ProductCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/cache")
public class CacheController {

    @Autowired
    ProductCache productCache;

    @GetMapping
    public ResponseEntity<Map<String, CacheModel>> getListCache() {
        return ResponseEntity.ok(ProductCache.getCacheMap());
    }
}
