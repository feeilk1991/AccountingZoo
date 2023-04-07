package com.example.accountingzoo.service;

import com.example.accountingzoo.exception.ResourceNotFoundException;
import com.example.accountingzoo.model.*;
import com.example.accountingzoo.repository.ProductRepository;
import lombok.AllArgsConstructor;
import javax.persistence.*;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

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
