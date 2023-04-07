package com.example.accountingzoo.model;

import com.example.accountingzoo.model.dictionary.MeasureType;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

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
