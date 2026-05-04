package org.ejercicio.cantina.repository;

import org.ejercicio.cantina.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
