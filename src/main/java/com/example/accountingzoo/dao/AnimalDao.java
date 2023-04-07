package com.example.accountingzoo.dao;

import com.example.accountingzoo.model.Animal;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface AnimalDao extends CrudOperations<Animal, Long> {
}
