package com.example.accountingzoo.controller;

import com.example.accountingzoo.model.Animal;
import com.example.accountingzoo.model.AnimalRequest;
import com.example.accountingzoo.model.AnimalResponse;
import com.example.accountingzoo.service.AnimalService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/animals")
public class AnimalController {
    private final AnimalService animalService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AnimalResponse> findAllAnimals() {
        return animalService.findAll();
    }

    @GetMapping("/{id}")
    public AnimalResponse findAnimalGetById (@PathVariable Long id) {
        return animalService.getAnimalById(id);
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createAnimal (@RequestBody AnimalRequest request) {
        final Long id = animalService.createAnimal(request);
        final URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @PatchMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public AnimalResponse updateAnimal (@PathVariable Long id, @Valid @RequestBody AnimalRequest request) {
        return animalService.updateAnimal(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnimal(@PathVariable Long id) {
        animalService.deleteAnimal(id);
        return ResponseEntity.noContent().build();
    }
}
