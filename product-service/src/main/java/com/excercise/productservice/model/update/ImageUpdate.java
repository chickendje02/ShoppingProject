package com.excercise.productservice.model.update;

import com.excercise.productservice.enumeration.TypeImage;
import com.excercise.productservice.model.orm.Image;
import com.excercise.productservice.model.orm.Product;
import lombok.Data;

@Data
public class ImageUpdate {

    private String imageName;

    private TypeImage typeImage;

    public Image buildModelCreate(ImageUpdate image, Product savedProduct) {
        return Image.builder()
                .imageName(image.getImageName())
                .typeImage(image.getTypeImage().toString())
                .product(savedProduct)
                .build();
    }
}
