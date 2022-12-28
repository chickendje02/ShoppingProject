package com.excercise.adminservice.controller;


import com.excercise.adminservice.service.CompanyInfoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company-info")
public class CompanyInfoController {

    CompanyInfoService companyInfoService;

    public CompanyInfoController(CompanyInfoService companyInfoService) {
        this.companyInfoService = companyInfoService;
    }

    @GetMapping
    public ResponseEntity getCompanyInfo() {
        return ResponseEntity.ok(companyInfoService.getCompanyInfo());
    }
}
