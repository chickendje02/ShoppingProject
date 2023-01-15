package com.excercise.productservice.model.update;

import com.excercise.productservice.enumeration.ActionType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LogUpdateModel {

    private ActionType actionType;

    private String content;

    public static LogUpdateModel prepareLogModelData(ActionType actionType, String content) {
        return LogUpdateModel.builder()
                .actionType(actionType)
                .content(content)
                .build();
    }
}
