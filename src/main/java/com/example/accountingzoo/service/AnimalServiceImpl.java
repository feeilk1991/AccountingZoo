package com.example.accountingzoo.service;

import com.example.accountingzoo.dao.AnimalDao;
import com.example.accountingzoo.model.Animal;
import com.example.accountingzoo.model.AnimalMapper;
import com.example.accountingzoo.model.AnimalRequest;
import com.example.accountingzoo.model.AnimalResponse;
import jakarta.annotation.Nonnull;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AnimalServiceImpl implements AnimalService {
    private final AnimalDao animalDao;

    @Nonnull
    @Override
    @Transactional(readOnly = true)
    public List<AnimalResponse> findAll() {
        return animalDao.findAll().stream().map(AnimalMapper::animalResponse).collect(Collectors.toList());
    }

    @Nonnull
    @Override
    @Transactional(readOnly = true)
    public AnimalResponse getAnimalById(Long id) {
        var animal = getAnimal(id);
        return AnimalMapper.animalResponse(animal);
    }

    @Override
    @Transactional
    public Long createAnimal(@Nonnull AnimalRequest request) {
        Animal animal = new Animal();
        animal.setName(request.getName());
        animal.setAnimalType(request.getAnimalType());
        animal.setConsumptions(animal.getConsumptions());
        animal.setPredator(animal.isPredator());
        animal.setConsumptions(animal.getConsumptions());

        return animalDao.create(animal);
    }

    @Nonnull
    @Override
    @Transactional
    public AnimalResponse updateAnimal (Long id, @Nonnull AnimalRequest request) {
        var animal = AnimalMapper.toDAO(request);
        animal.setId(id);
        var updateAnimal = animalDao.update(animal);
        return AnimalMapper.animalResponse(updateAnimal);
    }

    @Override
    @Nonnull
    @Transactional
    public void deleteAnimal (Long id) {
        var animal = getAnimal(id);
        if (animal != null)
            animalDao.delete(id);
    }

    private Animal getAnimal(Long id)
    {
        return Optional.ofNullable(animalDao.findById(id))
                .orElseThrow(EntityNotFoundException::new);
    }
}
