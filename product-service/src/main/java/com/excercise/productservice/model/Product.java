package com.excercise.productservice.model;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Data
@Entity(name = "product_sherwin")
public class Product {
    @Id
    @GeneratedValue
    private Long id;

    private String productName;

    private BigDecimal productPrice;

    private Long typeId;

    private Long vendorId;

    @OneToMany(mappedBy = "product")
    private List<Image> images;

    @OneToMany(mappedBy = "product")
    private List<Vendor> vendors;
}
