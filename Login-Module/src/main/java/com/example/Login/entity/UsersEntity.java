package com.example.Login.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "USERS")
@Data
public class UsersEntity {
    @Id
    @Column(name = "USER_ID")
    private UUID userId;
    @Column(name = "NAME")
    private String name;
    @Column(name = "USER_NAME")
    private String userName;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "AGE")
    private Integer age;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "PHONE_NUMBER")
    private Integer phoneNumber;
    @Column(name = "ADDRESS")
    private  String address;
    @Column(name = "STREET")
    private String street;
    @Column(name = "CITY")
    private String city;
    @Column(name = "STATE")
    private String state;
    @Column(name = "COUNTRY")
    private String country;
    @Column(name = "POSTAL_CODE")
    private String  postalCode;
    @Column(name="ACTIVE")
    private boolean active;
    @Column(name="VERIFIER")
    private Integer verifier;

}
