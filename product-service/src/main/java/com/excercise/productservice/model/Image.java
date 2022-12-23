package com.excercise.productservice.model;

import com.excercise.productservice.enumeration.TypeImage;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Entity(name = "image_sherwin")
public class Image {
    @Id
    private Long id;

    private String name;

    private String typeImage;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable=false)
    @JsonIgnore
    private Product product;
}
