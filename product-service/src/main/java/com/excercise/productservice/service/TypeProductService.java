package com.excercise.productservice.service;

import com.excercise.productservice.model.dto.TypeProductDTO;
import com.excercise.productservice.model.update.TypeProductUpdateModel;

import java.util.List;

public interface TypeProductService {

    List<TypeProductDTO> findAll();

    void addOrUpdateTypeProduct(TypeProductUpdateModel model);

    void deleteTypeProduct(Long id);
}
