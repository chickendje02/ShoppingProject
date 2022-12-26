package com.excercise.productservice.repository;

import com.excercise.productservice.model.orm.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {

}
