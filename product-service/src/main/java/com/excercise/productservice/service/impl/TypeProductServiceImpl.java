package com.excercise.productservice.service.impl;

import com.excercise.productservice.exception.CommonBusinessException;
import com.excercise.productservice.model.dto.TypeProductDTO;
import com.excercise.productservice.model.orm.TypeProduct;
import com.excercise.productservice.model.update.TypeProductUpdateModel;
import com.excercise.productservice.repository.TypeProductRepository;
import com.excercise.productservice.service.TypeProductService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TypeProductServiceImpl implements TypeProductService {

    @Autowired
    TypeProductRepository typeProductRepository;

    @Override
    public List<TypeProductDTO> findAll() {
        List<TypeProductDTO> result = new ArrayList<>();
        List<TypeProduct> data = typeProductRepository.findAll();
        data.forEach(item -> {
            result.add(this.mappingToDTO(item));
        });
        return result;
    }

    @Override
    public void addOrUpdateTypeProduct(TypeProductUpdateModel model) {
        this.validationAddOrUpdate(model);
        TypeProduct data = new TypeProduct(model.getId(), model.getTypeName());
        typeProductRepository.save(data);
    }

    @Override
    public void deleteTypeProduct(Long id) {

    }

    private void validationAddOrUpdate(TypeProductUpdateModel model) {
        if (StringUtils.isEmpty(model.getTypeName())) {
            throw new CommonBusinessException("Type name can not be emptied");
        }
        List<TypeProduct> data = typeProductRepository.findAll();
        data.stream().parallel().forEach(item -> {
            if (item.getTypeName().equalsIgnoreCase(model.getTypeName()) && model.getId() != item.getId()) {
                throw new CommonBusinessException("Type Name is existed");
            }
        });
    }

    private void validationDelete() {

    }

    private TypeProductDTO mappingToDTO(TypeProduct typeProduct) {
        return TypeProductDTO.builder()
                .id(typeProduct.getId())
                .typeName(typeProduct.getTypeName())
                .build();
    }
}
