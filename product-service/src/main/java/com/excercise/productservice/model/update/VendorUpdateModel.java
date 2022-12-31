package com.excercise.productservice.model.update;

import lombok.Data;

@Data
public class VendorUpdateModel {

    private Long vendorId;

    private String vendorName;

    private String country;
}
