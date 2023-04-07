package com.example.accountingzoo.service;

import com.example.accountingzoo.exception.ResourceNotFoundException;
import com.example.accountingzoo.model.Animal;
import com.example.accountingzoo.repository.AnimalRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AnimalService {
    private final AnimalRepository animalRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    public Animal getAnimalById(Long id) {
        return animalRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Animal not found with id: " + id));
    }

    public Animal createAnimal(Animal animal) {
        return animalRepository.save(animal);
    }

    public Animal updateAnimal(Long id, Animal updatedAnimal) {
        Animal animal = getAnimalById(id);
        animal.setName(updatedAnimal.getName());
        animal.setAnimalType(updatedAnimal.getAnimalType());
        return animalRepository.save(animal);
    }

    public void deleteAnimal(Long id) {
        animalRepository.deleteById(id);
    }

    public List<Animal> getAnimalFoodInfoFor7Days(LocalDate startDate) {
        LocalDate endDate = startDate.plusDays(7);

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Animal> query = cb.createQuery(Animal.class);
        Root<Animal> root = query.from(Animal.class);

        Predicate predicate = cb.lessThanOrEqualTo(root.get("lastFedDate"), endDate);

        query.select(root)
                .where(predicate)
                .orderBy(cb.asc(root.get("name")));

        return entityManager.createQuery(query).getResultList();
    }
}
