package com.excercise.productservice.model.orm;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity(name = "type_product_sherwin")
public class TypeProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String typeName;

    public TypeProduct(Long id, String typeName) {
        this.id = id;
        this.typeName = typeName;
    }

    public TypeProduct() {

    }
}
