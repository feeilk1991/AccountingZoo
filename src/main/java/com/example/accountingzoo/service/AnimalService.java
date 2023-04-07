package com.example.accountingzoo.service;

import com.example.accountingzoo.model.AnimalRequest;
import com.example.accountingzoo.model.AnimalResponse;
import org.springframework.lang.NonNull;

import java.util.List;

public interface AnimalService {

    @NonNull
    List<AnimalResponse> findAll();

    @NonNull
    AnimalResponse getAnimalById(@NonNull Long id);

    @NonNull
    Long createAnimal(@NonNull AnimalRequest request);

    @NonNull
    AnimalResponse updateAnimal(Long id, @NonNull AnimalRequest request);

    @NonNull
    void deleteAnimal (Long id);
}
