package com.excercise.loggingservice.controller;

import com.excercise.loggingservice.model.update.LogUpdateModel;
import com.excercise.loggingservice.service.LoggingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/logging")
public class LoggingController {

    LoggingService loggingService;

    public LoggingController(LoggingService loggingService) {
        this.loggingService = loggingService;
    }

    @PostMapping
    public ResponseEntity saveLog(@RequestBody LogUpdateModel logUpdateModel) {
        loggingService.saveLog(logUpdateModel);
        return ResponseEntity.ok("Ok");
    }
}
