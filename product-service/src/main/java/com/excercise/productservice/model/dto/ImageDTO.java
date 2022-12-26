package com.excercise.productservice.model.dto;

import com.excercise.productservice.enumeration.TypeImage;
import com.excercise.productservice.model.orm.Image;
import com.excercise.productservice.model.orm.Product;
import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class ImageDTO {

    private String id;

    private String imageName;

    private TypeImage typeImage;
}
