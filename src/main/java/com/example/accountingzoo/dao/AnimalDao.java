package com.example.accountingzoo.dao;

import com.example.accountingzoo.model.Animal;
import jakarta.annotation.Nonnull;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.lang.Nullable;

@NoRepositoryBean
public interface AnimalDao extends CrudOperations<Animal, Long> {
}
