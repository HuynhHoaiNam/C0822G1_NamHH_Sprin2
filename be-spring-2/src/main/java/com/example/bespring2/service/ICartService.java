package com.example.bespring2.service;

import com.example.bespring2.dto.IOrderDetail;
import com.example.bespring2.model.Cart;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICartService {
    Cart getCartByIdUser(@Param("idUser") Long idUser);

    List<IOrderDetail> getWatchInCart(Long iUser);

    void payWatch(Long idUser);

    void increaseQuantity(@Param("idOrderDetail") Long idOrderDetail);
}
