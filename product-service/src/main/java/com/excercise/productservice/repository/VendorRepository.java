package com.excercise.productservice.repository;

import com.excercise.productservice.model.orm.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VendorRepository extends JpaRepository<Vendor, Long> {

    Optional<Vendor> findById(Long id);
}
