package com.excercise.productservice.model;

import com.excercise.productservice.enumeration.TypeImage;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "image_sherwin")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imageName;

    private String typeImage;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "product_id")
    @JsonIgnore
    private Product product;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Image)) return false;
        Image user = (Image) o;
        return id != null && id.equals(user.getId());
    }

    @Override
    public int hashCode() {
        return 24;
    }
}
