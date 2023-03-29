package com.example.bespring2.service.impl;

import com.example.bespring2.dto.IOrderDetail;
import com.example.bespring2.model.Cart;
import com.example.bespring2.model.Watch;
import com.example.bespring2.repository.ICartRepository;
import com.example.bespring2.repository.IWatchRepository;
import com.example.bespring2.service.IWatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class WatchService implements IWatchService {
    @Autowired
    private IWatchRepository watchRepository;
    @Autowired
    private ICartRepository iCartRepository;

    @Override
    public Page<Watch> getListWatch(Pageable pageable, int trademarkId) {
        if (trademarkId == -1) {
            return watchRepository.getListWatch(pageable);
        }
        return watchRepository.getListWatchIdTrademark(pageable, trademarkId);
    }

    @Override
    public Watch getWatch(Long idInput) {
        return watchRepository.getWatch(idInput);
    }

    @Override
    public void addCart(Long idUser, Long idWatch) {
        List<IOrderDetail> orderDetailList = iCartRepository.getWatchInCart(idUser);
        for (int i = 0; i < orderDetailList.size(); i++) {
            if (orderDetailList.get(i).getIdWatch() == idWatch) {
                iCartRepository.increaseQuantity(orderDetailList.get(i).getIdOrder());
                return;
            }
        }
        watchRepository.addCart(idUser);
        Cart cart = iCartRepository.getCartByIdUser(idUser);
        watchRepository.addOrderDetail(cart.getId(), idWatch);
    }

    @Override
    public void addOrderDetail(Long idCart, Long idWatch) {
        watchRepository.addOrderDetail(idCart, idWatch);
    }

    @Override
    public void changeQuantity(Long idUser, Long valueChange, Long idWatch) {
        List<IOrderDetail> orderDetails = iCartRepository.getWatchInCart(idUser);
        for (int i = 0; i < orderDetails.size(); i++) {
            if (orderDetails.get(i).getIdWatch() == idWatch && orderDetails.get(i).getQuantity() < 2) {
                iCartRepository.deleteWatchByIdOrder(orderDetails.get(i).getIdOrder());
                return;
            } else if (orderDetails.get(i).getIdWatch() == idWatch && valueChange == 1) {
                iCartRepository.increaseQuantity(orderDetails.get(i).getIdOrder());
                return;
            } else if (orderDetails.get(i).getIdWatch() == idWatch && valueChange == 0) {
                iCartRepository.reduceQuantity(orderDetails.get(i).getIdOrder());
                return;
            }
        }
    }


}
