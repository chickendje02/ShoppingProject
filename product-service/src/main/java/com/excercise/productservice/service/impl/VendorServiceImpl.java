package com.excercise.productservice.service.impl;

import com.excercise.productservice.exception.CommonBusinessException;
import com.excercise.productservice.model.dto.VendorDTO;
import com.excercise.productservice.model.orm.Product;
import com.excercise.productservice.model.orm.Vendor;
import com.excercise.productservice.model.update.VendorUpdateModel;
import com.excercise.productservice.repository.ProductRepository;
import com.excercise.productservice.repository.VendorRepository;
import com.excercise.productservice.service.VendorService;
import com.excercise.productservice.utils.CommonQueryHandler;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class VendorServiceImpl extends CommonQueryHandler<Vendor, VendorDTO> implements VendorService {

    @Autowired
    VendorRepository vendorRepository;

    @Autowired
    ProductRepository productRepository;

    @Override
    public Map<String, Object> getListVendors() {
        return super.process();
    }

    @Override
    public VendorDTO getVendorById() {
        return null;
    }

    @Override
    public void addVendor(VendorUpdateModel model) {
        this.validation(model);
        Vendor vendor = this.markupData(model);
        vendorRepository.save(vendor);
    }

    @Override
    public void updateVendor(VendorUpdateModel model) {
        this.validation(model);
        Vendor vendor = this.markupData(model);
        vendorRepository.save(vendor);
    }

    @Override
    public void deleteVendor(Long id) {
        this.validationOnDelete(id);
        vendorRepository.deleteById(id);
    }

    @Override
    protected List getData() {
        return vendorRepository.findAll();
    }

    @Override
    protected VendorDTO builderToDTO(Vendor model) {
        return VendorDTO.builder()
                .id(model.getId())
                .vendorName(model.getVendorName())
                .country(model.getCountry())
                .build();
    }

    private void validation(VendorUpdateModel model) {
        if (StringUtils.isEmpty(model.getVendorName())) {
            throw new CommonBusinessException("Vendor name can not be emptied");
        }
        if (StringUtils.isEmpty(model.getCountry())) {
            throw new CommonBusinessException("Country can not be emptied");
        }
        List<Vendor> data = vendorRepository.findAll();
        data.stream().parallel().forEach(item -> {
            if (item.getVendorName().equalsIgnoreCase(model.getVendorName()) && model.getVendorId() != item.getId()) {
                throw new CommonBusinessException("Vendor Name is existed");
            }
        });
    }

    private void validationOnDelete(Long vendorId) {
        Optional<Product> product = productRepository.findByVendorId(vendorId);
        if (!product.isEmpty()) {
            throw new CommonBusinessException("Vendor is in used");
        }
    }

    private Vendor markupData(VendorUpdateModel model) {
        Vendor vendor = new Vendor();
        vendor.setId(model.getVendorId());
        vendor.setVendorName(model.getVendorName());
        vendor.setCountry(model.getCountry());
        return vendor;
    }
}
