package com.example.accountingzoo.model;

import com.example.accountingzoo.model.dictionary.MeasureType;
import com.example.accountingzoo.model.dictionary.ProductType;
import javax.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

@Entity
@Data
@ToString
@RequiredArgsConstructor
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double currentQuantity;
    @Enumerated(EnumType.STRING)
    private MeasureType measureType;
    @Enumerated(EnumType.STRING)
    private ProductType type;

    public Product(Long id, String name, ProductType type, double currentQuantity, MeasureType measureType) {
        this.id = id;
        this.type = type;
        this.measureType = measureType;
        this.name = name;
        this.currentQuantity = currentQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Product product = (Product) o;
        return id != null && Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
