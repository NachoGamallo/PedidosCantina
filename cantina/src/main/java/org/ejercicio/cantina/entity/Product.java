package org.ejercicio.cantina.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "producto")
@Data

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre" , nullable = false , unique = true)
    private String name;

    @Column(name = "precio" , nullable = false)
    private double price = 0.0;

    @Column(name = "stock", nullable = false)
    private int stock = 0;

}
