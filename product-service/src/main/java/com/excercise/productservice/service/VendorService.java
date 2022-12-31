package com.excercise.productservice.service;

import com.excercise.productservice.model.dto.VendorDTO;
import com.excercise.productservice.model.update.VendorUpdateModel;

import java.util.List;
import java.util.Map;

public interface VendorService {

    Map<String, Object> getListVendors();

    VendorDTO getVendorById();

    void addVendor(VendorUpdateModel model);

    void updateVendor(VendorUpdateModel model);

    void deleteVendor(Long id);
}
