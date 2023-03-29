package com.example.bespring2.repository;

import com.example.bespring2.model.Cart;
import com.example.bespring2.model.Watch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface IWatchRepository extends JpaRepository<Watch, Long> {

//    @Query(value = "select * from watch", nativeQuery = true)
//    List<Watch> getListWatch(@Param("nameWatch") String nameWatch);
//


    @Query(value = "select * from watch", nativeQuery = true)
    Page<Watch> getListWatch(Pageable pageable);


    @Query(value = "select * from watch where price between :priceFirst and :priceSecond", nativeQuery = true)
    Page<Watch> getListWatchPrice(Pageable pageable, int priceFirst, int priceSecond);


    @Query(value = "select * from watch where trademarkt_id=:trademarkId", nativeQuery = true)
    Page<Watch> getListWatchIdTrademark(Pageable pageable, @Param("trademarkId") int trademarkId);

    @Query(value = "select * from watch where price between :priceFirst and :priceSecond and trademarkt_id=:idTrademark", nativeQuery = true)
    Page<Watch> getListWatchIdTrademarkPrice(Pageable pageable, int priceFirst, int priceSecond, int idTrademark);

    @Query(value = "select * from watch where id=:idInput", nativeQuery = true)
    Watch getWatch(@Param("idInput") Long idInput);

    @Modifying
    @Query(value = "INSERT INTO `watch-management`.`cart` (`user_id`,flag) VALUES (:idUser,false)", nativeQuery = true)
    void addCart(@Param("idUser") Long idUser);

    @Modifying
    @Query(value = "INSERT INTO `watch-management`.`order_detail` (`cart_id`, `watch_id`,flag,quantity) VALUES (:idCart, :idWatch,false,1)", nativeQuery = true)
    void addOrderDetail(@Param("idCart") Long idCart, @Param("idWatch") Long idWatch);

}
