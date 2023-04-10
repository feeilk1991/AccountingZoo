package com.example.accountingzoo.repository;

import com.example.accountingzoo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository  extends JpaRepository<Product, Long> {
}
