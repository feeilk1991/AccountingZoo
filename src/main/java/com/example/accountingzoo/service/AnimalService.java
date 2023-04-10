package com.example.accountingzoo.service;

import com.example.accountingzoo.model.Animal;
import com.example.accountingzoo.model.AnimalRequest;
import com.example.accountingzoo.model.AnimalResponse;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AnimalService {

    @NonNull
    List<AnimalResponse> findAnimalsAll();

    @NonNull
    AnimalResponse getAnimalById(@NonNull Long id);

    @NonNull
    Animal createAnimal(@NonNull Animal request);

    @NonNull
    AnimalResponse updateAnimal(Long id, @NonNull Animal request);

    @NonNull
    void deleteAnimal (Long id);
}
