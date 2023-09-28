package com.dnb.authservice.repository;

import com.dnb.authservice.model.ERole;
import com.dnb.authservice.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    Optional<Role> findByName(ERole name);
}
