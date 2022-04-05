//package ug.bachelor.api;
//
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//import ug.bachelor.domain.Animal;
//import ug.bachelor.service.*;
//
//@RestController
//public class AnimalController {
//    private final AnimalService animalService;
//
//
//    public AnimalController(AnimalService animalService) {
//        this.animalService = animalService;
//    }
//
//    @PostMapping("/api/animal")
//    public Animal addAnimal(@RequestBody Animal animal ) {
//        Animal animalToAdd = new Animal();
//        animalToAdd = animal;
//        return animalService.updateAnimal(animalToAdd);
//    }
//}
