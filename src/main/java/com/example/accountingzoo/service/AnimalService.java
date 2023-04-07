package com.example.accountingzoo.service;

import com.example.accountingzoo.model.Animal;
import com.example.accountingzoo.model.AnimalRequest;
import com.example.accountingzoo.model.AnimalResponse;
import jakarta.annotation.Nonnull;

import java.util.List;

public interface AnimalService {

    @Nonnull
    List<AnimalResponse> findAll();

    @Nonnull
    AnimalResponse getAnimalById(@Nonnull Long id);

    Long createAnimal(@Nonnull AnimalRequest request);

    @Nonnull
    AnimalResponse updateAnimal(Long id, @Nonnull AnimalRequest request);

    @Nonnull
    void deleteAnimal (Long id);
}
