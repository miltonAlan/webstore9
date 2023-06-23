/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.packt.webstore.service;

import com.packt.webstore.dto.CartDto;
import com.packt.webstore.domain.Cart;

/**
 *
 * @author edgar
 */
public interface CartService {

    void create(CartDto cartDto);

    Cart read(String cartID);

    void update(String cartId, CartDto cartDto);

    void delete(String id);

    void addItem(String cartId, String productId);

    void removeItem(String cartId, String productId);
}
