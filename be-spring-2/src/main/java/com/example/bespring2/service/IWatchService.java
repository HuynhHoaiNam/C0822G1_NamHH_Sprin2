package com.example.bespring2.service;

import com.example.bespring2.model.Watch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IWatchService {
    Page<Watch> getListWatch(Pageable pageable,int trademarkId);

    Watch getWatch(Long idInput);

    void addCart(Long idUser, Long idWatch);

    void addOrderDetail(@Param("idCart") Long idCart, @Param("idWatch") Long idWatch);

    void changeQuantity(Long idUser,Long valueChange, Long idWatch);

}
