/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.packt.webstore.domain.repository.impl;

import com.packt.webstore.domain.CartItem;
import com.packt.webstore.service.ProductService;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author fing.labcom
 */
public class CartItemMapper implements RowMapper<CartItem> {
 
    private ProductService productService;

    public CartItemMapper(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public CartItem mapRow(ResultSet rs, int rowNum) throws SQLException {
        CartItem cartItem = new CartItem(rs.getString("ID"));
        cartItem.setProduct(productService.getProductById(rs.getString("PRODUCT_ID")));
        cartItem.setQuantity(rs.getInt("QUANTITY"));
        return cartItem;
    }
}
    

