package com.example.accountingzoo.dao;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import java.util.List;

@NoRepositoryBean
public interface CrudOperations<T, ID> {

    @Nullable
    T findById(@Nullable ID id);

    @NonNull
    List<T> findAll();

    @NonNull
    T update(@NonNull T entity);

    @Nullable
    T delete(@Nullable ID id);

    Long create(@NonNull T entity);
}
