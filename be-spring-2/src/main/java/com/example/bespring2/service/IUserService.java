package com.example.bespring2.service;

import com.example.bespring2.dto.request.ChangePasswordDto;
import com.example.bespring2.model.User;

import java.util.Optional;

public interface IUserService {
    Optional<User> findByUsername(String username);

    /**
     * Create by : NuongHT
     * Date create: 27/02/2023
     * Description: create method service of change password
     */
    void save(Long accountId);

    void changePassword(ChangePasswordDto changePasswordDto) throws Exception;

    Boolean existsAccountByUsername(String username);

    Boolean existsAccountByEmail(String email);

    void save(User user);

}

