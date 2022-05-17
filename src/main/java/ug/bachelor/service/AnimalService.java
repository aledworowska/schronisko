package ug.bachelor.service;


import org.springframework.beans.factory.annotation.Autowired;
import ug.bachelor.domain.Animal;
import ug.bachelor.repository.AnimalRepository;

import java.util.List;
import java.util.UUID;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import ug.bachelor.domain.enums.Sex;
import ug.bachelor.domain.enums.Species;


@Service
@Transactional
public class AnimalService {
    private final AnimalRepository animalRepository;


    @Autowired
    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public Iterable<Animal> allAnimals() {
        return animalRepository.findAll();
    }

    public Animal getAnimal(long id) {
        return animalRepository.findById(id).orElse(null);
    }

    public Animal addAnimal(Animal animal) {return animalRepository.save(animal);}

    public Animal updateAnimal(Animal animal) {
        Animal animalToUpdate = animalRepository.findById( animal.getId() ).orElse(null);
        animalToUpdate.setName(animal.getName());
        animalToUpdate.setSex(animal.getSex());
        animalToUpdate.setSpecies(animal.getSpecies());
        animalToUpdate.setReserved(animal.isReserved());
        animalToUpdate.setAge(animal.getAge());
        animalToUpdate.setDescription(animal.getDescription());
        animalToUpdate.setCity(animal.getCity());

        return animalRepository.save(animalToUpdate);
    }

    public void deleteAnimal(Animal animal) {
        animalRepository.deleteById(animal.getId());
    }
}