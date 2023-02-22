package com.sindallah.service;

import com.sindallah.entity.Product;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {

    Mono<Product> save(Product product);
    Flux<Product> getAllProducts();
    Mono<Void> deleteProduct(long id);
    Mono<ResponseEntity<Product>> update(Product product,long id);
}
