package ug.bachelor.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;
import ug.bachelor.domain.Animal;
import ug.bachelor.service.AnimalService;

import javax.validation.Valid;
import java.io.IOError;
import java.io.IOException;


@Controller
public class WebAnimalController {
    private final AnimalService animalService;


    public WebAnimalController(AnimalService animalService) {this.animalService = animalService;}

    @GetMapping(value="/")
    public String Menu(Model model){
        return "main-menu";
    }

    @GetMapping("/animal")
    public String animals(Model model){
        model.addAttribute("allAnimalsFromList", animalService.allAnimals());
        return "animal-all";
    }

    @GetMapping("/animal/add")
    public String addNewAnimal(Model model){
        model.addAttribute("animalToAdd", new Animal());

        return "animal-add";
    }

    @RequestMapping("/animal")
    public RedirectView addNewAnimal(@ModelAttribute("allAnimalsFromList") Animal animal, @RequestParam("image") MultipartFile multipartFile) throws IOException {
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        String uploadDir = "Animal-photos/" + animal.getId();
        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);


        animalService.addAnimal(animal);
        return new RedirectView("/animal",true);
    }

    @GetMapping("/animal/delete/{id}")
    public String deleteAnimal(@PathVariable("id") long id, Model model) {
        animalService.deleteAnimal(animalService.getAnimal(id));
        model.addAttribute("allAnimals",animalService.allAnimals());
        return "redirect:/animal";
    }
    @GetMapping("/animal/update/{id}")
    public String updateAnimal(@PathVariable("id") long id, Model model){
        Animal animalToUpdate = animalService.getAnimal(id);
        model.addAttribute("animalToUpdate",animalToUpdate);
        return "animal-update";
    }

    @PostMapping("/animal/update/{id}")
    public String updateAnimal(@PathVariable("id") long id, @ModelAttribute("animalToUpdate") Animal animalToUpdate, Model model){
        animalService.updateAnimal(animalToUpdate);
        return "redirect:/animal";
    }

}
