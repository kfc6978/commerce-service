package com.gtelant.commerce.service.repositories;

import com.gtelant.commerce.service.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
