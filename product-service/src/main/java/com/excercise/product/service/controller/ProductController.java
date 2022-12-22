package com.excercise.product.service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {


    @GetMapping("/hello")
    public String Hello(){
        return "Hello";
    }
}
