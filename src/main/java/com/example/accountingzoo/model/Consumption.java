package com.example.accountingzoo.model;

import com.example.accountingzoo.model.dictionary.MeasureType;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Embeddable
public class Consumption {
    private LocalDate date;
    private double amount;
    @Enumerated(EnumType.STRING)
    private MeasureType measureType;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
