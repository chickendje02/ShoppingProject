package com.excercise.productservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {


    @GetMapping("/hello")
    public String hello(){
        int a = 5/0;
        return "Hello";
    }
}
