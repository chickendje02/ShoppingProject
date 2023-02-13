package com.excercise.cartservice.model.update;

import lombok.Data;

@Data
public class CartUpdateModel {

    private int productId;

    private Long customerId;

    private int quantity;
}
