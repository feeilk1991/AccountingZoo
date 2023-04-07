package com.example.accountingzoo.model;

import com.example.accountingzoo.model.dictionary.AnimalType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@Accessors(chain = true)
public class AnimalResponse {
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private AnimalType animalType;

    private boolean isPredator;

    @ElementCollection
    private List<Consumption> consumptions = new ArrayList<>();
}
