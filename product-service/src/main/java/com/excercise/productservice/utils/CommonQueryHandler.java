package com.excercise.productservice.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class CommonQueryHandler<T, K> {

    private static final String KEY_DATA = "data";

    public Map<String, Object> process() {
        Map<String, Object> result = new HashMap<>();
        List<K> listDTO = new ArrayList<>();
        List<T> list = this.getData();
        this.mapToDTO(list, listDTO);
        result.put(KEY_DATA, listDTO);
        return result;
    }

    protected abstract List<T> getData();

    protected void mapToDTO(List<T> data, List<K> listDTO) {
        data.forEach(item -> {
            listDTO.add(this.builderToDTO(item));
        });
    }

    protected abstract K builderToDTO(T model);
}
