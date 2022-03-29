package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ug.bachelor.domain.Animal;
import ug.bachelor.service.AnimalService;


@Controller
public class WebAnimalController {
    private final AnimalService animalService;

    @Autowired
    public WebAnimalController(AnimalService animalService) {this.animalService = animalService;}

    @GetMapping("/animal")
    public String animals(Model model){
        model.addAttribute("allAnimalsFromList", animalService.getAnimalList());
        return "animal-all";
    }

    @GetMapping("/animal/add")
    public String addNewAnimal(Model model){
        model.addAttribute("animalToAdd", animalService.getAnimalList());
        return "animal-add";
    }

    @PostMapping("/animal")
    public String addNewAnimal(@ModelAttribute("animal") Animal animal) {
        animalService.addAnimal(animal);
        return "animal-all";
    }

    /*public String deleteAnimal(@PathVariable("id") long id, Model model){
        animalService.deleteAnimal(animalService.getAnimal(id));
       model.addAttribute("allAnimalsFromList",animalService.allAnimals());
   }*/

}
