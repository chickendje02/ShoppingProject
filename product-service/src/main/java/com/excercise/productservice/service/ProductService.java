package com.excercise.productservice.service;

import com.excercise.productservice.model.Product;
import com.excercise.productservice.model.ProductFilter;

import java.util.List;

public interface ProductService {

    public List<Product> findAll(ProductFilter filter);
}
