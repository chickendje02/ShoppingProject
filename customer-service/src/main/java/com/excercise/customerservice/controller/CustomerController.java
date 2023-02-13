package com.excercise.customerservice.controller;

import com.excercise.customerservice.model.update.CustomerUpdateModel;
import com.excercise.customerservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {


    @Autowired
    CustomerService customerService;

    @PostMapping("/sign-up")
    public ResponseEntity<String> signUp(@RequestBody CustomerUpdateModel model) {
        customerService.save(model);
        return ResponseEntity.ok("Ok");
    }

    @GetMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {
        return ResponseEntity.ok(customerService.login(username, password));
    }
}
