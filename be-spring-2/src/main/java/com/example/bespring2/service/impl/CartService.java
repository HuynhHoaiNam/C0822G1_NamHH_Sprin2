package com.example.bespring2.service.impl;

import com.example.bespring2.dto.IOrderDetail;
import com.example.bespring2.model.Cart;
import com.example.bespring2.repository.ICartRepository;
import com.example.bespring2.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CartService implements ICartService {

    @Autowired
    private ICartRepository iCartRepository;

    @Override
    public Cart getCartByIdUser(Long idUser) {
        return iCartRepository.getCartByIdUser(idUser);
    }

    @Override
    public List<IOrderDetail> getWatchInCart(Long idUser) {
        return iCartRepository.getWatchInCart(idUser);
    }

    @Override
    public void payWatch(Long idUser) {
        iCartRepository.payWatch(idUser);
    }

    @Override
    public void increaseQuantity(Long idOrderDetail) {
//        List<IOrderDetail> orderDetailList= iCartRepository.getWatchInCart()
    }
}
