package com.example.accountingzoo.controller;

import com.example.accountingzoo.model.Animal;
import com.example.accountingzoo.service.AnimalService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/animals")
public class AnimalController {
    private AnimalService animalService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Animal> findAllAnimals() {
        return animalService.findAnimalsAll();
    }

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Animal createAnimal(@RequestBody Animal animal) {
        return animalService.createAnimal(animal);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Animal updateAnimal (@PathVariable Long id, @RequestBody Animal animal) {
        return animalService.updateAnimal(id, animal);
    }

    @GetMapping("/{id}")
    public Animal getAnimal (@PathVariable Long id) {
        return animalService.getAnimalById(id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAnimal (@PathVariable Long id) {
        animalService.deleteAnimal(id);
        return ResponseEntity.noContent().build();
    }
}
