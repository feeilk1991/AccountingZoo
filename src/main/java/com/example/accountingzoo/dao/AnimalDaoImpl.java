package com.example.accountingzoo.dao;

import com.example.accountingzoo.model.Animal;
import jakarta.annotation.Nonnull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class AnimalDaoImpl implements AnimalDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Nullable
    @Override
    public Animal findById(@Nonnull Long id) {
        Animal department = entityManager.find(Animal.class, id);
        if (department == null) {
            return null;
        }
        return department;
    }

    @Nonnull
    @Override
    public List<Animal> findAll() {
        TypedQuery<Animal> query = entityManager.createQuery("SELECT animal FROM Animal animal", Animal.class);
        if (query == null)
            return List.of();
        return query.getResultList();
    }

    @Nonnull
    @Override
    public Animal update(@Nonnull Animal animal) {
        if (animal != null) {
            if (animal.getId() != null) {
                entityManager.persist(animal);
            } else {
                entityManager.merge(animal);
            }
        }
        return animal;
    }

    @Nullable
    @Override
    public Animal delete(@Nonnull Long id) {
        Animal animal = entityManager.find(Animal.class, id);
        if (animal == null) {
            return null;
        }
        entityManager.remove(animal);
        return animal;
    }

    @Override
    @Nonnull
    public Long create(@Nonnull Animal entity) {
        entityManager.persist(entity);
        return entity.getId();
    }
}
