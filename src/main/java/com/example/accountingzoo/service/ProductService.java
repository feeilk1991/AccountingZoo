package com.example.accountingzoo.service;

import com.example.accountingzoo.exception.ResourceNotFoundException;
import com.example.accountingzoo.model.*;
import com.example.accountingzoo.repository.ProductRepository;
import jakarta.annotation.Nonnull;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
public interface ProductService {
    List<ProductResponse> findAll();

    @Nonnull
    ProductResponse getById(Long id);

    Long createProduct(@Nonnull ProductRequest request);

    @Nonnull
    ProductResponse updateProduct(Long id, @Nonnull ProductRequest request);

    @Nonnull
    void deleteProduct(Long id);
}
