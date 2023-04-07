package com.example.accountingzoo.dao;

import com.example.accountingzoo.model.Product;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;
import javax.persistence.*;
import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Nullable
    @Override
    public Product findById(@NonNull Long id) {
        return entityManager.find(Product.class, id);
    }

    @NonNull
    @Override
    public List<Product> findAll() {
        TypedQuery<Product> query = entityManager.createQuery("SELECT p FROM Product p", Product.class);
        return query.getResultList();
    }

    @NonNull
    @Override
    public Product update(@NonNull Product person) {
        return entityManager.merge(person);
    }

    @Nullable
    @Override
    public Product delete(@NonNull Long id) {
        Product product = entityManager.find(Product.class, id);
        if (product == null) {
            return null;
        }
        entityManager.remove(product);
        return product;
    }

    @Nullable
    @Override
    public Long create(@NonNull Product entity) {
        entityManager.persist(entity);
        return entity.getId();
    }
}
