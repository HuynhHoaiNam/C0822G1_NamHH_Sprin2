package com.example.bespring2.service;

import com.example.bespring2.model.Role;
import com.example.bespring2.model.RoleName;

import java.util.Optional;

public interface IRoleService {
    Optional<Role> findByName(RoleName name);
}