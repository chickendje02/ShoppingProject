package com.excercise.productservice.repository;

import com.excercise.productservice.model.orm.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findById(Long id);

    Optional<List<Product>> findAllByProductNameContainsAndVendorIdAndProductPriceLessThan(String productName, Long id, BigDecimal price, Pageable pageRequest);

    Optional<Product> findByVendorId(Long vendorId);

    Optional<Product> findByTypeId(Long typeProductId);

    Optional<List<Product>> findAllByProductNameContainsAndProductPriceLessThan(String productName, BigDecimal price, Pageable pageRequest);

    Optional<List<Product>> findAllByProductNameContains(String productName, Pageable pageRequest);

    Optional<List<Product>> findAllByProductNameContainsAndVendorId(String productName, Long vendorId, Pageable pageRequest);
}
