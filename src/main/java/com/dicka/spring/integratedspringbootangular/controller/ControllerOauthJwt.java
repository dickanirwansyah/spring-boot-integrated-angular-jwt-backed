package com.dicka.spring.integratedspringbootangular.controller;

import com.dicka.spring.integratedspringbootangular.entity.Hotel;
import com.dicka.spring.integratedspringbootangular.entity.Users;
import com.dicka.spring.integratedspringbootangular.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/springjwt")
public class ControllerOauthJwt {

    private final GenericService genericService;

    @Autowired
    public ControllerOauthJwt(GenericService genericService){
        this.genericService=genericService;
    }

    @PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
    @RequestMapping(value = "/hotels", method = RequestMethod.GET)
    public ResponseEntity<List<Hotel>> getAllHotels(){
        return Optional.ofNullable(genericService.getAllHotels())
                .map(hotels -> new ResponseEntity<>(hotels, HttpStatus.OK))
                .orElse(new ResponseEntity<List<Hotel>>(HttpStatus.NOT_FOUND));
    }


    @PreAuthorize("hasAuthority('ADMIN_USER')")
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<List<Users>> getAllUsers(){
        return Optional.ofNullable(genericService.getAllUsers())
                .map(users -> new ResponseEntity<>(users, HttpStatus.OK))
                .orElse(new ResponseEntity<List<Users>>(HttpStatus.NOT_FOUND));
    }
}
