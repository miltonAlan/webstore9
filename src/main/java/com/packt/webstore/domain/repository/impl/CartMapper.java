/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.packt.webstore.domain.repository.impl;

import com.packt.webstore.domain.Cart;
import com.packt.webstore.domain.CartItem;
import com.packt.webstore.service.ProductService;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

/**
 *
 * @author fing.labcom
 */
public class CartMapper implements RowMapper<Cart> {

    private CartItemMapper cartItemMapper;
    private NamedParameterJdbcTemplate jdbcTempleate;

    public CartMapper(NamedParameterJdbcTemplate jdbcTempleate, ProductService productService) {
        this.jdbcTempleate = jdbcTempleate;
        cartItemMapper = new CartItemMapper(productService);
    }

    public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {
        String id = rs.getString("ID");
        Cart cart = new Cart(id);

        String SQL = String.format("SELECT * FROM CART_ITEM WHERE CART_ID = '%s'", id);
        List<CartItem> cartItems = jdbcTempleate.query(SQL, cartItemMapper);
        cart.setCartItems(cartItems);
        return cart;

    }

}
