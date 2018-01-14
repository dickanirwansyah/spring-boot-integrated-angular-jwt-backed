package com.dicka.spring.integratedspringbootangular.service.impl;

import com.dicka.spring.integratedspringbootangular.entity.Roles;
import com.dicka.spring.integratedspringbootangular.entity.Users;
import com.dicka.spring.integratedspringbootangular.repository.RolesRepository;
import com.dicka.spring.integratedspringbootangular.repository.UsersRepository;
import com.dicka.spring.integratedspringbootangular.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Repository
@Transactional
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;
    private final RolesRepository rolesRepository;

    @Autowired
    public UsersServiceImpl(UsersRepository usersRepository, RolesRepository rolesRepository){
        this.usersRepository=usersRepository;
        this.rolesRepository=rolesRepository;
    }

    @Override
    public Users createUsers(Users users) {
        ShaPasswordEncoder passwordEncoder = new ShaPasswordEncoder(256);
        users.setPassword(passwordEncoder.encodePassword(users.getPassword(), null));
        Roles roles = rolesRepository.findOne(2);
        List<Roles> rolesList = new ArrayList<>();
        rolesList.add(roles);
        users.setRoles(rolesList);
        return usersRepository.save(users);
    }
}
