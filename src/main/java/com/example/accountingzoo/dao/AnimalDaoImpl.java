package com.example.accountingzoo.dao;

import com.example.accountingzoo.model.Animal;
import javax.persistence.*;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
@Transactional
public class AnimalDaoImpl implements AnimalDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Nullable
    @Override
    public Animal findById(@NonNull Long id) {
        Animal department = entityManager.find(Animal.class, id);
        if (department == null) {
            return null;
        }
        return department;
    }

    @NonNull
    @Override
    public List<Animal> findAll() {
        TypedQuery<Animal> query = entityManager.createQuery("SELECT animal FROM Animal animal", Animal.class);
        if (query == null)
            return List.of();
        return query.getResultList();
    }

    @NonNull
    @Override
    public Animal update(@NonNull Animal animal) {
        if (animal.getId() != null) {
            entityManager.persist(animal);
        } else {
            entityManager.merge(animal);
        }
        return animal;
    }

    @Nullable
    @Override
    public Animal delete(@NonNull Long id) {
        Animal animal = entityManager.find(Animal.class, id);
        if (animal == null) {
            return null;
        }
        entityManager.remove(animal);
        return animal;
    }

    @Override
    @NonNull
    public Long create(@NonNull Animal entity) {
        entityManager.persist(entity);
        return entity.getId();
    }
}
