package com.excercise.cartservice.model.orm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Setter
@Getter
@Entity(name = "cart_product_sherwin")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CartProductMapping {

    @EmbeddedId
    private CartProductKey cartProductKey;

    private int quantity;
}
