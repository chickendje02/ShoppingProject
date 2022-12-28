package com.excercise.adminservice.service.impl;


import com.excercise.adminservice.exception.CommonBusinessException;
import com.excercise.adminservice.model.orm.SystemConfig;
import com.excercise.adminservice.repository.SystemConfigRepository;
import com.excercise.adminservice.service.CompanyInfoService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class CompanyInfoServiceImpl implements CompanyInfoService {

    private static final String ADDRESS_KEY = "address";

    private static final String PHONE_KEY = "phone_number";

    SystemConfigRepository systemConfigRepository;

    public CompanyInfoServiceImpl(SystemConfigRepository systemConfigRepository) {
        this.systemConfigRepository = systemConfigRepository;
    }


    @Override
    public Map<String, String> getCompanyInfo() {
        Map<String, String> result = new HashMap<>();
        Optional<SystemConfig> phone = systemConfigRepository.findByConfigKey(ADDRESS_KEY);
        Optional<SystemConfig> address = systemConfigRepository.findByConfigKey(PHONE_KEY);
        phone.ifPresent(systemConfig -> result.put(ADDRESS_KEY, systemConfig.getConfigValue()));
        address.ifPresent(systemConfig -> result.put(PHONE_KEY, systemConfig.getConfigValue()));
        if (result.isEmpty()) {
            throw new CommonBusinessException("There's no value for address and phone's company");
        }
        return result;
    }
}
