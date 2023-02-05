package com.excercise.adminservice.model.dto;

import com.excercise.adminservice.enumeration.TypeImage;
import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class ImageDTO {

    private String imageName;

    private TypeImage typeImage;
}
