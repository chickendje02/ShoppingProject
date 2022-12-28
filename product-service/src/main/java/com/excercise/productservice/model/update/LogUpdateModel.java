package com.excercise.productservice.model.update;

import com.excercise.productservice.enumeration.ActionType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LogUpdateModel {

    private ActionType actionType;

    private String content;
}
