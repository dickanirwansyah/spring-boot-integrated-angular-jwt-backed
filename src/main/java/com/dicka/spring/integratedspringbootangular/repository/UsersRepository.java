package com.dicka.spring.integratedspringbootangular.repository;

import com.dicka.spring.integratedspringbootangular.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Integer> {

    Users findByUsername(String username);
}
