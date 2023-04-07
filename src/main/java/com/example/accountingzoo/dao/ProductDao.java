package com.example.accountingzoo.dao;

import com.example.accountingzoo.model.Product;
import jakarta.annotation.Nonnull;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.lang.Nullable;

@NoRepositoryBean
public interface ProductDao extends CrudOperations<Product, Long> {
    @Nullable
    Product delete(@Nonnull Long id);
}