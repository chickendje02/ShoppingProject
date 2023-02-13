package com.excercise.cartservice.service;

import com.excercise.cartservice.model.update.CartUpdateModel;

public interface CartCommandService {

    void addProduct(CartUpdateModel model);

    void removeProduct(CartUpdateModel model);

    void addCart(Long customerId);

}
