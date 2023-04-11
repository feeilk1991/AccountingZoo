package com.example.accountingzoo.service;

import com.example.accountingzoo.exception.ResourceNotFoundException;
import com.example.accountingzoo.model.Animal;
import com.example.accountingzoo.repository.AnimalRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.module.ResolutionException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AnimalServiceImpl implements AnimalService {
    final AnimalRepository animalRepository;

    @Override
    @NonNull
    @Transactional
    public List<Animal> findAnimalsAll() {
        return animalRepository.findAll().stream().map(a ->
                new Animal(a.getId(),
                a.getName(),
                a.getAnimalType())).collect(Collectors.toList());
    }

    @Override
    @NonNull
    @Transactional
    public Animal getAnimalById(@NonNull Long id) {
        return animalRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not amimals %s" + id));
    }

    @Override
    @NonNull
    public Animal createAnimal(@NonNull Animal request) {
        Animal animal = new Animal();
        animal.setName(request.getName());
        animal.setAnimalType(request.getAnimalType());
        animal.setConsumptions(animal.getConsumptions());
        animal.setPredator(animal.isPredator());
        animal.setConsumptions(animal.getConsumptions());

        return animal;
    }

    @Override
    @NonNull
    public Animal updateAnimal(Long id, @NonNull Animal request) {
        Optional<Animal> animalOptional = animalRepository.findById(id);
        if (animalOptional.isPresent()) {
            Animal animal = animalOptional.get();
            animal.setName(request.getName());
            animal.setAnimalType(request.getAnimalType());
            animal.setPredator(request.isPredator());

            animalRepository.save(animal);
        } else throw new ResolutionException();

        return animalOptional.get();
    }

    @Override
    public void deleteAnimal(Long id) {
        Animal animal = animalRepository.getReferenceById(id);

        animalRepository.delete(animal);
    }
//    public List<Animal> getAnimalFoodInfoFor7Days(LocalDate startDate) {
//        LocalDate endDate = startDate.plusDays(7);
//
//        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//        CriteriaQuery<Animal> query = cb.createQuery(Animal.class);
//        Root<Animal> root = query.from(Animal.class);
//
//        Predicate predicate = cb.lessThanOrEqualTo(root.get("lastFedDate"), endDate);
//
//        query.select(root)
//                .where(predicate)
//                .orderBy(cb.asc(root.get("name")));
//
//        return entityManager.createQuery(query).getResultList();
//    }
}
