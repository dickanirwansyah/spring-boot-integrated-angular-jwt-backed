package com.dicka.spring.integratedspringbootangular.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "hotel",
        catalog = "dbjjwt")
public class Hotel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idhotel;

    @Column(name = "name", nullable = false)
    private String name;

    public int getIdhotel(){
        return idhotel;
    }

    public void setIdhotel(int idhotel){
        this.idhotel=idhotel;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }
}
