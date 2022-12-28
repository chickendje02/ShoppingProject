package com.excercise.loggingservice.model.update;

import com.excercise.loggingservice.enumeration.ActionType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LogUpdateModel {

    private ActionType actionType;

    private String content;
}
