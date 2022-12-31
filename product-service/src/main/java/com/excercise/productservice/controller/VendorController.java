package com.excercise.productservice.controller;


import com.excercise.productservice.constants.Constants;
import com.excercise.productservice.model.update.VendorUpdateModel;
import com.excercise.productservice.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vendor")
public class VendorController {

    @Autowired
    VendorService vendorService;

    @GetMapping
    public ResponseEntity getListVendor() {
        return ResponseEntity.ok(vendorService.getListVendors());
    }

    @PostMapping
    public ResponseEntity addVendor(@RequestBody VendorUpdateModel model) {
        vendorService.addVendor(model);
        return ResponseEntity.ok(Constants.OK);
    }

    @PutMapping
    public ResponseEntity updateVendor(@RequestBody VendorUpdateModel model) {
        vendorService.updateVendor(model);
        return ResponseEntity.ok(Constants.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteVendor(@PathVariable Long id) {
        vendorService.deleteVendor(id);
        return ResponseEntity.ok(Constants.OK);
    }
}
