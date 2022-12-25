package com.excercise.productservice.dto;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Id;

@Data
@Builder
public class VendorDTO {

    private Long id;

    private String vendorName;

    private String country;
}
