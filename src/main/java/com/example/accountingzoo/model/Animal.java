package com.example.accountingzoo.model;

import com.example.accountingzoo.model.dictionary.AnimalType;
import javax.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "animals")
public class Animal {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private AnimalType animalType;
    @ElementCollection
    private List<Consumption> consumptions = new ArrayList<>();
    private boolean isPredator;

    public Animal(Long id, String name, AnimalType animalType) {
        this.id = id;
        this.animalType = animalType;
        this.name = name;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Animal animal = (Animal) o;
        return id != null && Objects.equals(id, animal.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
