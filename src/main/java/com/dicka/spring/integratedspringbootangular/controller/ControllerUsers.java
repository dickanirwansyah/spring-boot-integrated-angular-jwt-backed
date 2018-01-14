package com.dicka.spring.integratedspringbootangular.controller;

import com.dicka.spring.integratedspringbootangular.entity.Users;
import com.dicka.spring.integratedspringbootangular.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
public class ControllerUsers {

    private final UsersService usersService;

    @Autowired
    public ControllerUsers(UsersService usersService){
        this.usersService=usersService;
    }

    @RequestMapping(value = "/created", method = RequestMethod.POST)
    public ResponseEntity<Users> singup(@RequestBody Users users)throws Exception{
        return Optional.ofNullable(usersService.createUsers(users))
                .map(singup_users -> new ResponseEntity<>(singup_users, HttpStatus.CREATED))
                .orElseThrow(()-> new Exception("failed !"));
    }
}
