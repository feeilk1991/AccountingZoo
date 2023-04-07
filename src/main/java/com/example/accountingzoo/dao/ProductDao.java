package com.example.accountingzoo.dao;

import com.example.accountingzoo.model.Product;
import javax.persistence.*;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

@NoRepositoryBean
public interface ProductDao extends CrudOperations<Product, Long> {
    @Nullable
    Product delete(@NonNull Long id);
}