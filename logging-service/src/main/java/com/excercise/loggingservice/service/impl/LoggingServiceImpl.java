package com.excercise.loggingservice.service.impl;

import com.excercise.loggingservice.exception.CommonBusinessException;
import com.excercise.loggingservice.model.orm.LogModel;
import com.excercise.loggingservice.model.update.LogUpdateModel;
import com.excercise.loggingservice.repository.LoggingRepository;
import com.excercise.loggingservice.service.LoggingService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class LoggingServiceImpl implements LoggingService {

    LoggingRepository loggingRepository;


    public LoggingServiceImpl(LoggingRepository loggingRepository) {
        this.loggingRepository = loggingRepository;
    }


    @Override
    public void saveLog(LogUpdateModel model) {
        try{
            Thread.sleep(5000);
        }catch (Exception e){
            e.printStackTrace();
        }
        this.validation(model);
        LogModel logModel = this.prepareData(model);
        loggingRepository.save(logModel);
    }

    private void validation(LogUpdateModel model) {
        if (!Objects.nonNull(model)) {
            throw new CommonBusinessException("Invalid model log", HttpStatus.INTERNAL_SERVER_ERROR.value());
        } else if (!Objects.nonNull(model.getActionType())) {
            throw new CommonBusinessException("Invalid action type", HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
    }

    private LogModel prepareData(LogUpdateModel model){
        return LogModel.builder()
                .action(model.getActionType().name())
                .content(model.getContent())
                .build();
    }
}
