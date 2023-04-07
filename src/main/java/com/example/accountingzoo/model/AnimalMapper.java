package com.example.accountingzoo.model;

public class AnimalMapper {
    public static AnimalResponse animalResponse(Animal animal) {
        return new AnimalResponse(animal.getId(), animal.getName(),
                animal.getAnimalType(), animal.isPredator(), animal.getConsumptions());
    }

    public static Animal toDAO(AnimalRequest request) {
        var animal = new Animal();
        animal.setName(request.getName());
        animal.setAnimalType(request.getAnimalType());
        animal.setPredator(animal.isPredator());
        animal.setConsumptions(request.getConsumptions());

        return animal;
    }
}
