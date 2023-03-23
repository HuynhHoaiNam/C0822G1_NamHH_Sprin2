package com.example.bespring2.repository;

import com.example.bespring2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;
@Repository
@Transactional
public interface IUserRepository extends JpaRepository<User,Integer> {
//    @Query(value = "select * from user where username = :username", nativeQuery = true)
//    Optional<User> findByUsername(@Param("username") String username);
//
//    @Query(value = "select * from user where username = :username",nativeQuery = true)
//    User userLogin(@Param("username") String username);
    Boolean existsByEmail(String email);
    Boolean existsByUsername(String username);

    Optional<User> findByUsername(String username);
}