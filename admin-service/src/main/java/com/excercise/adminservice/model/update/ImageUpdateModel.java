package com.excercise.adminservice.model.update;

import com.excercise.adminservice.enumeration.TypeImage;
import lombok.Data;

@Data
public class ImageUpdateModel {

    private String imageName;

    private TypeImage typeImage;

}
