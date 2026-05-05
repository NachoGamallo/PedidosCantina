package org.ejercicio.cantina.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "alumno")
@Data

public class Alumn {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre" , nullable = false)
    private String name;

    @Column(name = "curso" , nullable = false)
    private String curs;

    @Column(name = "telefono", nullable = false, unique = true)
    private int phone_number;

}
