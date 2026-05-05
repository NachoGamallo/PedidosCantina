package org.ejercicio.cantina.repository;

import org.ejercicio.cantina.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    
    List<Order> getOrderByStatusIsFalse(boolean status);

    List<Order> getOrderByAlumn_Id(int alumnId);
    
}
