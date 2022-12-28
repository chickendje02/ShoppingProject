package com.excercise.adminservice.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SystemConfigDTO {

    private String key;

    private String value;
}
