package com.excercise.productservice.model.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class ProductDTO {
    private long id;

    private String productName;

    private long typeId;

    private List<ImageDTO> listImages;

//    private String vendorName;

    private Long vendorId;

    private BigDecimal productPrice;
}
