package com.dicka.spring.integratedspringbootangular.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "roles",
        catalog = "dbjjwt")
public class Roles implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idroles;

    @Column(name = "roles_name", nullable =false)
    private String roles_name;

    @Column(name = "description", nullable=false)
    private String description;


    public int getIdroles(){
        return idroles;
    }

    public void setIdroles(int idroles){
        this.idroles=idroles;
    }

    public String getRolesName(){
        return roles_name;
    }

    public void setRolesName(String roles_name){
        this.roles_name = roles_name;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description=description;
    }
}
