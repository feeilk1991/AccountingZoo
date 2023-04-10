package com.example.accountingzoo.service;

import com.example.accountingzoo.model.*;

import org.springframework.lang.NonNull;

import java.util.List;
public interface ProductService {
    List<ProductResponse> findAll();

    @NonNull
    ProductResponse getById(Long id);

    Long createProduct(@NonNull ProductRequest request);

    @NonNull
    ProductResponse updateProduct(Long id, @NonNull ProductRequest request);

    @NonNull
    void deleteProduct(Long id);
}
