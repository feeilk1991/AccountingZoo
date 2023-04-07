package com.example.accountingzoo.dao;

import com.example.accountingzoo.model.Product;
import jakarta.annotation.Nonnull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Nullable
    @Override
    public Product findById(@Nonnull Long id) {
        return entityManager.find(Product.class, id);
    }

    @Nonnull
    @Override
    public List<Product> findAll() {
        TypedQuery<Product> query = entityManager.createQuery("SELECT p FROM Product p", Product.class);
        return query.getResultList();
    }

    @Nonnull
    @Override
    public Product update(@Nonnull Product person) {
        return entityManager.merge(person);
    }

    @Nullable
    @Override
    public Product delete(@Nonnull Long id) {
        Product product = entityManager.find(Product.class, id);
        if (product == null) {
            return null;
        }
        entityManager.remove(product);
        return product;
    }

    @Nullable
    @Override
    public Long create(@Nonnull Product entity) {
        entityManager.persist(entity);
        return entity.getId();
    }
}
