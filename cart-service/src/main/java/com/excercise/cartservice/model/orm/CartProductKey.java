package com.excercise.cartservice.model.orm;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class CartProductKey implements Serializable {

    private Long cartId;

    private int productId;
}
