package com.example.accountingzoo.model;

import com.example.accountingzoo.model.dictionary.MeasureType;
import com.example.accountingzoo.model.dictionary.ProductType;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
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
}
