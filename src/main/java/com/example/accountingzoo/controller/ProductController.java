package com.example.accountingzoo.controller;

import com.example.accountingzoo.model.Product;
import com.example.accountingzoo.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<Product> getAnimalById(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        return ResponseEntity.ok(product);
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product createProduct = productService.createProduct(product);
        return ResponseEntity.created(URI.create("/products/" + createProduct.getId())).body(createProduct);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct (@PathVariable Long id, @RequestBody Product product) {
        Product updateProduct = productService.updateAnimal(id, product);
        return ResponseEntity.ok(updateProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct (@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    // Обработчики HTTP-запросов, использующие ProductService
}
