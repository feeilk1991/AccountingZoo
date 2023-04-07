package com.example.accountingzoo.model;

import com.example.accountingzoo.model.dictionary.MeasureType;
import com.example.accountingzoo.model.dictionary.ProductType;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ProductRequest {
    @NotEmpty(message = "{field.is.empty}")
    private String name;
    private double currentQuantity;
    private MeasureType measureType;
    private ProductType type;
}
