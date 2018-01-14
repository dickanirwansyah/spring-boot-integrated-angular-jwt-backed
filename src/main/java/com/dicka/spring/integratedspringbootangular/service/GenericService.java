package com.dicka.spring.integratedspringbootangular.service;

import com.dicka.spring.integratedspringbootangular.entity.Hotel;
import com.dicka.spring.integratedspringbootangular.entity.Users;

import java.util.List;

public interface GenericService {

    List<Users> getAllUsers();

    List<Hotel> getAllHotels();

    Users findUserByUsersname(String username);
}
