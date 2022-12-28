package com.excercise.productservice.service.impl;

import com.excercise.productservice.model.update.LogUpdateModel;
import com.excercise.productservice.proxy.LogProxy;
import com.excercise.productservice.service.LogService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl implements LogService {

    LogProxy logProxy;

    public LogServiceImpl(LogProxy logProxy) {
        this.logProxy = logProxy;
    }

    @Async
    @Override
    public void saveLog(LogUpdateModel logUpdateModel) {
        logProxy.saveLog(logUpdateModel);
    }
}
