package com.excercise.productservice.repository;

import com.excercise.productservice.model.orm.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<List<Product>> findAllByProductNameContainsAndProductPriceLessThanAndVendorVendorNameContains(String productName, BigDecimal productPrice, String vendorName);

    Optional<Product> findById(Long id);
}
