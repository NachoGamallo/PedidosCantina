package org.ejercicio.cantina.repository;

import org.ejercicio.cantina.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product getProductById(Integer id);
}
