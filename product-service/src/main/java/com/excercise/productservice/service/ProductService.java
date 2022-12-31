package com.excercise.productservice.service;

import com.excercise.productservice.model.dto.ProductDTO;
import com.excercise.productservice.model.filter.ProductFilter;
import com.excercise.productservice.model.update.ProductUpdateModel;

import java.util.List;

public interface ProductService {

    List<ProductDTO> findAll(ProductFilter filter);

    void saveProduct(ProductUpdateModel product);

    ProductDTO getProductDetail(Long id);

    void removeProduct(Long id);
}
