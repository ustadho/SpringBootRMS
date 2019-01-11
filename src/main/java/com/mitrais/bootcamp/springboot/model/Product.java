package com.mitrais.bootcamp.springboot.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "m_product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Double price;
    @Column(columnDefinition = "boolean default false")
    private Boolean discontinued;

}
