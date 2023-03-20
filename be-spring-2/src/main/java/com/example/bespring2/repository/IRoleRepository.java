package com.example.bespring2.repository;

import com.example.bespring2.model.Role;
import com.example.bespring2.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IRoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName name);
}

