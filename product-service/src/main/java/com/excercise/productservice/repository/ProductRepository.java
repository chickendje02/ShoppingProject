package com.excercise.productservice.repository;

import com.excercise.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<List<Product>> findAllByProductNameContainsAndVendorsVendorNameContains(String productName,String vendorName);
}
