package com.excercise.loggingservice.service;

import com.excercise.loggingservice.model.update.LogUpdateModel;

public interface LoggingService {

    void saveLog(LogUpdateModel model);
}
