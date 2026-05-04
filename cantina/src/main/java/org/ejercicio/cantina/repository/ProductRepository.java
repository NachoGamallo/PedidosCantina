package org.ejercicio.cantina.repository;

import org.ejercicio.cantina.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
