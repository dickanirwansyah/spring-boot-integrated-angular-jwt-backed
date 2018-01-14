package com.dicka.spring.integratedspringbootangular.userdetails;

import com.dicka.spring.integratedspringbootangular.entity.Users;
import com.dicka.spring.integratedspringbootangular.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users users = usersRepository.findByUsername(username);

        if(users == null){
            throw new UsernameNotFoundException
                    (String.format("opps..sorry username doesn't exist !", username));
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        users.getGetRoles().forEach(roles -> {
            authorities.add(new SimpleGrantedAuthority(roles.getRolesName()));
        });

        UserDetails userDetails = new User(users.getUsername(), users.getPassword(), authorities);

        return userDetails;
    }
}
