package com.dicka.spring.integratedspringbootangular.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users",
        catalog = "dbjjwt")
public class Users implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idusers;

    @NotNull
    @Column(name = "firstname", nullable = false)
    private String firstname;

    @NotNull
    @Column(name = "lastname", nullable = false)
    private String lastname;

    @NotNull
    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @NotNull
    @Column(name = "password", nullable = false)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "idusers", referencedColumnName = "idusers"),
            inverseJoinColumns = @JoinColumn(name = "idroles", referencedColumnName = "idroles"))
    private List<Roles> roles = new ArrayList<Roles>();

    public List<Roles> getGetRoles(){
        return roles;
    }

    public void setRoles(List<Roles> roles){
        this.roles=roles;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password=password;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username=username;
    }

    public String getLastname(){
        return lastname;
    }

    public void setLastname(String lastname){
        this.lastname=lastname;
    }

    public String getFirstname(){
        return firstname;
    }

    public void setFirstname(String firstname){
        this.firstname=firstname;
    }

    public int getIdusers(){
        return idusers;
    }

    public void setIdusers(int idusers){
        this.idusers=idusers;
    }
}
