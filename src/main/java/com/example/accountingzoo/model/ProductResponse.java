package com.example.accountingzoo.model;

import com.example.accountingzoo.model.dictionary.MeasureType;
import com.example.accountingzoo.model.dictionary.ProductType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@AllArgsConstructor
@Accessors(chain = true)
public class ProductResponse {
    private Long id;
    private String name;
    private double currentQuantity;
    @Enumerated(EnumType.STRING)
    private MeasureType measureType;
    @Enumerated(EnumType.STRING)
    private ProductType type;
}
