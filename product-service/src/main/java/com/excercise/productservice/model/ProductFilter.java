package com.excercise.productservice.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductFilter {

    private String name;

    private BigDecimal price;

    private String vendorName;

}
