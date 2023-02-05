package com.excercise.productservice.cache;


import lombok.Data;

@Data
public class CacheModel<T> {

    private T data;
    private Long expiredTime;

    private static void abc(){

    }
}

