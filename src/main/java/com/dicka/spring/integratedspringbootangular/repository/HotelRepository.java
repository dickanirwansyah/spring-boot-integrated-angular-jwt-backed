package com.dicka.spring.integratedspringbootangular.repository;

import com.dicka.spring.integratedspringbootangular.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Integer>{
}
