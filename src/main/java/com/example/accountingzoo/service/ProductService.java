package com.example.accountingzoo.service;

import com.example.accountingzoo.model.*;

import org.springframework.lang.NonNull;

import java.util.List;
public interface ProductService {
    List<Product> findAllProducts();

    @NonNull
    Product getProductId(Long id);

    Product createProduct(@NonNull Product request);

    @NonNull
    Product updateProduct(Long id, @NonNull Product request);

    @NonNull
    void deleteProduct(Long id);
}
