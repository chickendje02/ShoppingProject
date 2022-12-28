package com.excercise.productservice.utils;

import com.excercise.productservice.exception.CommonBusinessException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.experimental.UtilityClass;
import org.springframework.http.HttpStatus;

@UtilityClass
public class UtilFunction {

    private static ObjectMapper mapper = new ObjectMapper();

    public static <T> String convertToJson(T object) {
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException ex) {
            throw new CommonBusinessException(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
    }
}
