package com.excercise.productservice.model.update;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class ProductUpdateModel {
    private Long id;

    private String productName;

    private BigDecimal productPrice;

    private int productQuantity;

    private Long typeId;

    private Long vendorId;

    private List<ImageUpdateModel> imageUpdate;
}
