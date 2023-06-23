/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.packt.webstore.domain.repository;

import com.packt.webstore.dto.CartDto;
import com.packt.webstore.domain.Cart;

/**
 *
 * @author fing.labcom
 */
public interface CartRepository {

    void create(CartDto cartDto);

    Cart read(String id);

    void update(String id, CartDto cartDto);

    void delete(String id);

    void addItem(String cartId, String productId);

    void removeItem(String cartId, String productId);

 }
