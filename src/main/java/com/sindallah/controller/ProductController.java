package com.sindallah.controller;

import com.sindallah.entity.Product;
import com.sindallah.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/hello")
    private Mono<String> sayHello() {
        return Mono.just("Hello Reactive");
    }

    @PostMapping("/product")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Product> createProduct(@RequestBody Product product){
        return productService.save(product);
    }

    @GetMapping("/products")
    public Flux<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @DeleteMapping("/product/{id}")
    public Mono<Void> deleteProduct(@PathVariable long id){
        return productService.deleteProduct(id);

    }

    @PutMapping("product/{id}")
    public Mono<ResponseEntity<Product>> updateProduct(@RequestBody Product product,
                                                       @PathVariable long id){
        return productService.update(product,id);

    }
}
