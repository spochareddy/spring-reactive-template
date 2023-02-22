package com.sindallah.repository;

import com.sindallah.entity.Product;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository  extends
        ReactiveCrudRepository<Product, Long> {
}
