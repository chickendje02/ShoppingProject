package com.excercise.productservice.service;

import com.excercise.productservice.model.dto.VendorDTO;

import java.util.List;

public interface VendorService {

    List<VendorDTO> getListVendors();

    VendorDTO getVendorById();

    void addVendor(VendorDTO vendorDTO);

    void updateVendor(VendorDTO vendorDTO);

    void deleteVendor(Long id);
}
