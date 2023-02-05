package com.excercise.adminservice.model.filter;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductFilter {

    private String name;

    private BigDecimal price;

    private Long vendorId;

    private int pageNumber;

    private int pageSize;

    @Override
    public String toString() {
        return name + ":" + price + ":" + vendorId + ":" + pageNumber + ":" + pageSize;
    }
}
