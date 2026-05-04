package org.ejercicio.cantina.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "pedido")
@Data

public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "alumno", nullable = false)
    private Alumn alumn;

    @ManyToOne
    @JoinColumn(name = "producto", nullable = false)
    private Product product;

    @Column(name = "cantidad", nullable = false)
    private int quantity = 0;

    @CreationTimestamp
    @Column(name = "fechaPedido" , nullable = false)
    private LocalDateTime created_at;

    @Column(name = "entregado", nullable = false)
    private boolean status = false;

}
