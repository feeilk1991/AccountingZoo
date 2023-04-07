package com.example.accountingzoo.dao;

import jakarta.annotation.Nonnull;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.lang.Nullable;

import java.util.List;

@NoRepositoryBean
public interface CrudOperations<T, ID> {

    @Nullable
    T findById(@Nonnull ID id);

    @Nonnull
    List<T> findAll();

    @Nonnull
    T update(@Nonnull T entity);

    @Nullable
    T delete(@Nonnull ID id);

    Long create(@Nonnull T entity);
}
