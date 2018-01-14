package com.dicka.spring.integratedspringbootangular.service.impl;

import com.dicka.spring.integratedspringbootangular.entity.Hotel;
import com.dicka.spring.integratedspringbootangular.entity.Users;
import com.dicka.spring.integratedspringbootangular.repository.HotelRepository;
import com.dicka.spring.integratedspringbootangular.repository.UsersRepository;
import com.dicka.spring.integratedspringbootangular.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Repository
public class GenericServiceImpl implements GenericService{

    private final UsersRepository usersRepository;
    private final HotelRepository hotelRepository;

    @Autowired
    public GenericServiceImpl(UsersRepository usersRepository, HotelRepository hotelRepository){
        this.usersRepository=usersRepository;
        this.hotelRepository=hotelRepository;
    }

    @Override
    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public Users findUserByUsersname(String username) {
        return usersRepository.findByUsername(username);
    }
}
