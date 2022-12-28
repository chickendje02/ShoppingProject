package com.excercise.productservice.proxy;

import com.excercise.productservice.model.update.LogUpdateModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("logging-service")
public interface LogProxy {

    @PostMapping("/logging")
    ResponseEntity saveLog(@RequestBody LogUpdateModel logUpdateModel);
}
