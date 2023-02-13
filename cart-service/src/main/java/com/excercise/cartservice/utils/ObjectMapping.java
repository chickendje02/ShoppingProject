package com.excercise.cartservice.utils;

import com.excercise.customerservice.exception.CommonBusinessException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.experimental.UtilityClass;
import lombok.extern.log4j.Log4j2;

@UtilityClass
@Log4j2
public class ObjectMapping {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static <T>  String writeObject(T object){
        try{
            return objectMapper.writeValueAsString(object);
        }catch (Exception e){
            log.error("Failed to write value ", e.getCause());
            throw new CommonBusinessException(e.getMessage());
        }
    }

    public static <T> T readValue(String json, Class<T> valueType){
        try {
            return objectMapper.readValue(json, valueType);
        } catch (Exception e) {
            log.error("Failed to read value ", e.getCause());
            throw new CommonBusinessException(e.getMessage());
        }
    }
}
