package com.dicka.spring.integratedspringbootangular.repository;

import com.dicka.spring.integratedspringbootangular.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<Roles, Integer> {
}
