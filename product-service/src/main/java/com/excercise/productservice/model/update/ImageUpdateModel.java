package com.excercise.productservice.model.update;

import com.excercise.productservice.enumeration.TypeImage;
import com.excercise.productservice.model.orm.Image;
import lombok.Data;

@Data
public class ImageUpdateModel {

    private String imageName;

    private TypeImage typeImage;

    public Image buildModelCreate(ImageUpdateModel image, Long productId) {
        return Image.builder()
                .imageName(image.getImageName())
                .typeImage(image.getTypeImage().toString())
                .productId(productId)
                .build();
    }
}
