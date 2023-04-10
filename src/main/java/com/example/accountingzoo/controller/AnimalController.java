package com.example.accountingzoo.controller;

import com.example.accountingzoo.model.Animal;
import com.example.accountingzoo.model.AnimalRequest;
import com.example.accountingzoo.model.AnimalResponse;
import com.example.accountingzoo.repository.AnimalRepository;
import com.example.accountingzoo.service.AnimalService;
import com.example.accountingzoo.service.AnimalServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private AnimalService animalService;

    @Autowired
    private AnimalRepository animalRepository;

    @PostMapping("/create")
    public Animal createAnimal(@RequestBody Animal animal) {
        Animal createResponse = animalService.createAnimal(animal);
        return createResponse;
    }

    @PutMapping("/update")
    public Student updateStudent(@RequestBody Student student) {
        Student updateResponse = studentService.update(student);
        return updateResponse;
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Long id) {
        Student getReponse = studentService.get(id);
        return getReponse;
    }

    @DeleteMapping("/delete")
    public String deleteStudent(@RequestBody Student student) {
        studentService.delete(student);
        return "Record deleted succesfully";
    }
}
