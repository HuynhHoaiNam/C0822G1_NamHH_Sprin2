package com.example.bespring2.repository;

import com.example.bespring2.dto.IOrderDetail;
import com.example.bespring2.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface ICartRepository extends JpaRepository<Cart, Long> {
    @Query(value = "select * from cart where user_id = :idUser order by id desc limit 1", nativeQuery = true)
    Cart getCartByIdUser(@Param("idUser") Long idUser);

    @Query(value = "select od.id                 as idOrder,\n" +
            "       od.watch_id           as idWatch,\n" +
            "       w.name                as watchName,\n" +
            "       w.price               as price,\n" +
            "       od.quantity           as quantity,\n" +
            "       w.price * od.quantity as money\n" +
            "from user\n" +
            "         join cart c on user.id = c.user_id\n" +
            "         join order_detail od on c.id = od.cart_id\n" +
            "         join watch w on od.watch_id = w.id\n" +
            "where user.id = :idUser\n" +
            "  and od.flag = false", nativeQuery = true)
    List<IOrderDetail> getWatchInCart(@Param("idUser") Long idUser);

    @Modifying
    @Query(value = "update order_detail join cart c on c.id = order_detail.cart_id set order_detail.flag = true where c.user_id=:idUser", nativeQuery = true)
    void payWatch(@Param("idUser") Long idUser);

    @Modifying
    @Query(value = "update order_detail\n" +
            "set quantity= quantity + 1\n" +
            "where order_detail.id = :idOrderDetail", nativeQuery = true)
    void increaseQuantity(@Param("idOrderDetail") Long idOrderDetail);

    @Modifying
    @Query(value = "update order_detail\n" +
            "set quantity= quantity - 1\n" +
            "where order_detail.id = :idOrderDetail", nativeQuery = true)
    void reduceQuantity(@Param("idOrderDetail") Long idOrderDetail);

    @Modifying
    @Query(value = " update order_detail\n" +
            "    set flag = true\n" +
            "    where order_detail.id = :idOrderDetail", nativeQuery = true)
    void deleteWatchByIdOrder(@Param("idOrderDetail") Long idOrderDetail);

}
