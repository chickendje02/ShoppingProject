package com.excercise.adminservice.proxy;


import com.excercise.adminservice.constant.CommonConstant;
import com.excercise.adminservice.model.dto.ProductDTO;
import com.excercise.adminservice.model.filter.ProductFilter;
import com.excercise.adminservice.model.update.ProductUpdateModel;
import feign.Headers;
import org.bouncycastle.cert.ocsp.Req;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.List;

@FeignClient("product-service")
public interface ProductProxy {

    @GetMapping(CommonConstant.DEFAULT_PRODUCT_URL + "/find-all")
    List<ProductDTO> findAll(@RequestParam String name
            , @RequestParam BigDecimal price
            , @RequestParam Long vendorId
            , @RequestParam int pageNumber
            , @RequestParam int pageSize);

    @GetMapping(CommonConstant.DEFAULT_PRODUCT_URL + "/get-product-detail/{Tesst}")
    ResponseEntity getProductDetail(@PathVariable(name = "Tesst") Long id);

    @PostMapping(CommonConstant.DEFAULT_PRODUCT_URL)
    ResponseEntity addProduct(@RequestBody ProductUpdateModel product);

    @PutMapping(CommonConstant.DEFAULT_PRODUCT_URL)
    ResponseEntity updateProduct(@RequestBody ProductUpdateModel product);

    @DeleteMapping(CommonConstant.DEFAULT_PRODUCT_URL + "/delete-product/{id}")
    ResponseEntity removeProduct(@PathVariable Long id);
}
