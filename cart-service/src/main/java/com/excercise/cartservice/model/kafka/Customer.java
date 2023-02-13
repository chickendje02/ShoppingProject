package com.excercise.cartservice.model.kafka;

import lombok.Data;

@Data
public class Customer {

    private Long id;

    private String username;

    private String password;

    private String phoneNumber;
}
