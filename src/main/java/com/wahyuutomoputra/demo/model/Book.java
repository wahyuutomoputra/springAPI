package com.wahyuutomoputra.demo.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Book")
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
}
