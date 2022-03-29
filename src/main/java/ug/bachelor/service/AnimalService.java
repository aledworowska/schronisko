package ug.bachelor.service;


import ug.bachelor.domain.Animal;
import java.util.List;
import java.util.ArrayList;
import java.util.UUID;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AnimalService {

    List<Animal> animalList = new ArrayList<>();

    public Animal addAnimal(Animal animal){
        Animal animalToAdd = new Animal(UUID.randomUUID().toString(), animal.getName(),animal.getSex(),animal.getAge(),animal.getDescription(),animal.getSpecies(),animal.isReserved());
        animalList.add(animalToAdd);
        return animalToAdd;
    }
    public List<Animal> getAnimalList(){return animalList;}

    //public Animal getAnimal(long id) {return }


}