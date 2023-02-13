package com.excercise.cartservice.controller;

import com.excercise.cartservice.model.update.CartUpdateModel;
import com.excercise.cartservice.service.CartCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartCommandService cartCommandService;

    @PostMapping
    public ResponseEntity<String> addProductToCart(@RequestBody CartUpdateModel model) {
        cartCommandService.addProduct(model);
        return ResponseEntity.ok("Ok");
    }
}
