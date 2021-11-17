package com.simo.psp3.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String surname;
    private String phonenumber;
    private String email;
    private String address;
    private String password;

    public User(String name, String surname, String phonenumber, String email, String address, String country, String password) {
        this.name = name;
        this.surname = surname;
        this.phonenumber = phonenumber;
        this.email = email;
        this.address = address;
        this.password = password;
    }
}
