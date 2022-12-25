package com.excercise.productservice.service;

import com.excercise.productservice.dto.ProductDTO;
import com.excercise.productservice.model.Product;
import com.excercise.productservice.model.ProductFilter;

import java.util.List;

public interface ProductService {

    public List<ProductDTO> findAll(ProductFilter filter);

    public void saveProduct(Product product);
}
