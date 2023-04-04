package com.example.accountingzoo.model;

import com.example.accountingzoo.model.dictionary.AnimalType;
import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "animal")
public class Animal {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private AnimalType animalType;

}
