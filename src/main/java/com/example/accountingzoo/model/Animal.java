package com.example.accountingzoo.model;

import com.example.accountingzoo.model.dictionary.AnimalType;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "animals")
public class Animal {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private AnimalType animalType;

    private boolean isPredator;

    @ElementCollection
    private List<Consumption> consumptions = new ArrayList<>();

}
