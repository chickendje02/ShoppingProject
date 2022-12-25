package com.excercise.productservice.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ProductDTO {
    private long id;

    private String productName;

    private long typeId;

    private List<ImageDTO> listImages;

    private String vendorName;
}
