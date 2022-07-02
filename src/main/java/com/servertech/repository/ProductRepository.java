package com.servertech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.servertech.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
