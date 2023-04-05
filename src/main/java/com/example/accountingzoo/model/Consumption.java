package com.example.accountingzoo.model;

import com.example.accountingzoo.model.dictionary.MeasureType;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Embeddable
@Data
public class Consumption {
    private LocalDate date;
    private double amount;
    @Enumerated(EnumType.STRING)
    private MeasureType measureType;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
