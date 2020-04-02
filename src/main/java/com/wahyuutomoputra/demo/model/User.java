package com.wahyuutomoputra.demo.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "User")
@Data
public class User {
    @Id
    private String email;
    private String password;
    private String nama;
}
