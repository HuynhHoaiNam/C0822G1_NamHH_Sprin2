package com.example.bespring2.service.impl;

import com.example.bespring2.dto.request.ChangePasswordDto;
import com.example.bespring2.model.User;
import com.example.bespring2.repository.IUserRepository;
import com.example.bespring2.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository iUserRepository;

    /**
     * Created by: SyTV
     * Date created: 27/02/2023
     *
     * @param username
     * @return account
     */
    @Override
    public Optional<User> findByUsername(String username) {
        return iUserRepository.findByUsername(username);
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Create by : NuongHT
     * Date create: 28/02/2023
     * Description: create reponsitory call database and check account by method findByUserId
     */


    @Override
    public void save(Long accountId) {
        iUserRepository.save(accountId);
    }

    @Override
    public void changePassword(ChangePasswordDto changePasswordDto) throws Exception {
        User user = iUserRepository.findByUserId(changePasswordDto.getAccountId());
        if (user == null) {
            throw new Exception("Account null");
        }
        user.setPassword(passwordEncoder.encode(changePasswordDto.getNewPass()));
        iUserRepository.save(user);
    }

    /**
     * Created by: SyTV
     * Date created: 27/02/2023
     * Function: findByUserName
     *
     * @param username
     * @return true false
     */
    @Override
    public Boolean existsAccountByUsername(String username) {
        return iUserRepository.existsAccountByUserName(username);
    }

    /**
     * Created by: SyTV
     * Date created: 27/02/2023
     * Function: findByUserName
     *
     * @param email
     * @return true false
     */
    @Override
    public Boolean existsAccountByEmail(String email) {
        return iUserRepository.existsAccountByEmail(email);
    }

    /**
     * Created by: SyTV
     * Date created: 27/02/2023
     * Function: findByUserName
     *
     * @param user
     */
    @Override
    public void save(User user) {
        iUserRepository.save(user);
    }

}