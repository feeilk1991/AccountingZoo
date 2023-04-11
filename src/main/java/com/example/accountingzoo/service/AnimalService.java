package com.example.accountingzoo.service;

import com.example.accountingzoo.model.Animal;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.List;

public interface AnimalService {

    @NonNull
    List<Animal> findAnimalsAll();

    @NonNull
    Animal getAnimalById(Long id);

    @NonNull
    Animal createAnimal(@NonNull Animal request);

    @NonNull
    Animal updateAnimal(Long id, @NonNull Animal request);

    @NonNull
    void deleteAnimal (Long id);
}
