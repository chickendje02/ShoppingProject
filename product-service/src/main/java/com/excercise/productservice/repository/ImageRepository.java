package com.excercise.productservice.repository;

import com.excercise.productservice.model.orm.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Long> {
    List<Image> deleteByProductId(Long id);
}
