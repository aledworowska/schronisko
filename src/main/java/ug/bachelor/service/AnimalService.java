package ug.bachelor.service;


import ug.bachelor.domain.Animal;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.UUID;
import javax.swing.*;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ug.bachelor.domain.enums.Sex;
import ug.bachelor.domain.enums.Species;

@Service
@Transactional
public class AnimalService {

    Animal animal = new Animal(UUID.randomUUID().toString(), "Lucky", Sex.MALE, 8, /*new JTextField("cos")*/ "przyjazny dla dzieci", Species.DOG,false);
    Animal animal2 = new Animal(UUID.randomUUID().toString(), "Bonifacy", Sex.MALE, 3, /*new JTextField("cos")*/ "", Species.CAT,false);

    List<Animal> animalList = new ArrayList<>((Arrays.asList(animal,animal2)));


    public Animal addAnimal(Animal animal){
        Animal animalToAdd = new Animal(UUID.randomUUID().toString(), animal.getName(),animal.getSex(),animal.getAge(),animal.getDescription(),animal.getSpecies(),animal.isReserved());
        animalList.add(animalToAdd);
        return animalToAdd;
    }
    public List<Animal> getAnimalList(){return animalList;}

    //public Animal getAnimal(long id) {return }


}