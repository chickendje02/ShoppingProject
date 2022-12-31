package com.excercise.productservice.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TypeProductDTO {

    private Long id;

    private String typeName;
}
