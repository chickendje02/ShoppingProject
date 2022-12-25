package com.excercise.productservice.dto;

import com.excercise.productservice.enumeration.TypeImage;
import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class ImageDTO {

    private String id;

    private String imageName;

    private TypeImage typeImage;

}
