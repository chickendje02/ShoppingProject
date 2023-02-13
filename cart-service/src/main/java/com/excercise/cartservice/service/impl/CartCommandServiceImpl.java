package com.excercise.cartservice.service.impl;

import com.excercise.cartservice.model.orm.Cart;
import com.excercise.cartservice.model.orm.CartProductKey;
import com.excercise.cartservice.model.orm.CartProductMapping;
import com.excercise.cartservice.model.update.CartUpdateModel;
import com.excercise.cartservice.repository.CartProductMappingRepository;
import com.excercise.cartservice.repository.CartRepository;
import com.excercise.cartservice.service.CartCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class CartCommandServiceImpl implements CartCommandService {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    CartProductMappingRepository cartProductMappingRepository;

    @Override
    public void addProduct(CartUpdateModel model) {
        Long cartId = 0L;
        Optional<Cart> cart = cartRepository.findByCustomerId(model.getCustomerId());
        if (cart.isPresent()) {
            cartId = cart.get().getId();
        } else {
            Cart newCart = cartRepository.save(buildCartModel(model));
            cartId = newCart.getId();
        }
        cartProductMappingRepository.save(buildCartProductMappingModel(cartId, model));
    }

    @Override
    public void removeProduct(CartUpdateModel model) {

    }

    @Override
    public void addCart(Long customerId) {
        Cart cart = new Cart();
        cart.setCustomerId(customerId);
        cartRepository.save(cart);
    }

    private Cart buildCartModel(CartUpdateModel model) {
        Cart cart = new Cart();
        cart.setCustomerId(model.getCustomerId());
        return cart;
    }

    private CartProductMapping buildCartProductMappingModel(Long cartId, CartUpdateModel model) {
        CartProductKey key = new CartProductKey();
        key.setProductId(model.getProductId());
        key.setCartId(cartId);
        CartProductMapping detail = new CartProductMapping();
        detail.setCartProductKey(key);
        detail.setQuantity(model.getQuantity());
        return detail;
    }
}
