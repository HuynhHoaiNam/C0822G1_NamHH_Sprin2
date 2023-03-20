package com.example.bespring2.repository;

import com.example.bespring2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User,Integer> {

    Boolean existsAccountByUserName(String username);

    Boolean existsAccountByEmail(String email);


    @Query(value = "select * from `user` where user_name = :username", nativeQuery = true)
    Optional<User> findByUsername(@Param("username") String username);

    /**
     * Create by : NuongHT
     * Date create: 27/02/2023
     * Description: create query get account by accountID and save newPass allow accountID
     *
     * @param 'accountId'
     * @return account
     */
    @Query(value = "select * from `user` where id = :accountId", nativeQuery = true)
    User findByUserId(@Param("accountId") Long accountId);


    @Query(value = "update user set password = :newPass where account_id= :accountId",nativeQuery = true)
    void save(@Param("accountId") Long accountId);
}

