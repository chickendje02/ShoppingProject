package com.excercise.productservice.repository;


import com.excercise.productservice.model.orm.TypeProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeProductRepository extends JpaRepository<TypeProduct, Long> {
    List<TypeProduct> findAll();
}
