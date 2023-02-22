package com.sindallah.service.impl;

import com.sindallah.entity.Product;
import com.sindallah.repository.ProductRepository;
import com.sindallah.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

@Autowired
ProductRepository repository;
    @Override
    public Mono<Product> save(Product product) {
         return repository.save(product);
    }

    @Override
    public Flux<Product> getAllProducts() {
         return repository.findAll();
    }

    @Override
    public Mono<Void> deleteProduct(long id) {
        return repository.deleteById(id);
    }

    @Override
    public Mono<ResponseEntity<Product>> update(Product product, long id) {

        Mono<Product> productMono = repository.findById(id);

        return  productMono.flatMap((existingProduct) -> {
            existingProduct.setId(product.getId());
            existingProduct.setName(product.getName());
            existingProduct.setDescription(product.getDescription());
            return repository.save(existingProduct);
        }).thenReturn(new ResponseEntity<>(HttpStatusCode.valueOf(200)));

    }
}
