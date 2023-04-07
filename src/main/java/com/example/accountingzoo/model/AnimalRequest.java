package com.example.accountingzoo.model;

import com.example.accountingzoo.model.dictionary.AnimalType;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.ElementCollection;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.ArrayList;
import java.util.List;

@Data
@Accessors(chain = true)
public class AnimalRequest {
    private String name;
    @Enumerated(EnumType.STRING)
    private AnimalType animalType;

    private boolean isPredator;

    @ElementCollection
    private List<Consumption> consumptions = new ArrayList<>();
}
