package ug.bachelor.web;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;
import ug.bachelor.domain.Animal;
import ug.bachelor.domain.User;
import ug.bachelor.service.AnimalService;
import ug.bachelor.service.CityService;

import javax.validation.Valid;
import java.io.IOException;


@Controller
public class WebAnimalController {
    private final AnimalService animalService;
    private final CityService cityService;


    public WebAnimalController(AnimalService animalService, CityService cityService) {
        this.animalService = animalService;
        this.cityService = cityService;
    }

    @GetMapping(value="/")
    public String Menu(Model model){
        return "main-menu";
    }

    @GetMapping(value="/contact") public String Contact(){return "contact";}
    @GetMapping(value="/admin/contact") public String ContactAdmin(){return "contact-admin";}

    @GetMapping(value="/admin")
    public String Menu_admin(Model model){
        return "admin-menu";
    }





    @GetMapping("/animal")
    public String animals(Model model){
        model.addAttribute("allAnimalsFromList", animalService.allAnimals());
        return "animal-all";
    }

    @GetMapping("/admin/animal")
    public String animalsAdmin(Model model){
        model.addAttribute("allAnimalsFromList", animalService.allAnimals());
        return "animal-all-admin";
    }

    @GetMapping("/admin/animal/add")
    public String addNewAnimal(Model model){
        model.addAttribute("allCities", cityService.allCities());
        model.addAttribute("animalToAdd", new Animal());

        return "animal-add";
    }

//    @PostMapping("/animal")
//    public String addNewAnimal(@ModelAttribute("allAnimalsFromList") Animal animal)  {
//        animalService.addAnimal(animal);
//        return "redirect:/animal";
//    }

    @RequestMapping("/admin/animal") //Kopia powyższego kontrollera dla jpg
    public String addNewAnimal(@ModelAttribute ("animalToAdd") @Valid Animal animal, BindingResult bindingResult , @RequestParam("image") MultipartFile multipartFile, Model model) throws IOException {

        if (bindingResult.hasErrors()) {
            System.out.println("Validation error found!");
            model.addAttribute("allCities", cityService.allCities());
            return "animal-add";
        }

        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        animal.setPhoto(fileName);
        Animal tempAnimal = animalService.addAnimal(animal);
        String uploadDir = "Animal-photos/" + tempAnimal.getId();
        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
        return "redirect:/admin/animal";
    }
    @GetMapping("/animal/{id}")
    public String animalPage(@PathVariable("id") long id, Model model){
        Animal animalToShow = animalService.getAnimal(id);
        model.addAttribute("animal",animalToShow);
        return "animal-page";
    }
    @GetMapping("/admin/animal/delete/{id}")
    public String deleteAnimal(@PathVariable("id") long id, Model model) {
        animalService.deleteAnimal(animalService.getAnimal(id));
        model.addAttribute("allAnimals",animalService.allAnimals());
        return "redirect:/admin/animal";
    }
    @GetMapping("/admin/animal/update/{id}")
    public String updateAnimal(@PathVariable("id") long id, Model model){
        Animal animalToUpdate = animalService.getAnimal(id);
        model.addAttribute("animalToUpdate",animalToUpdate);
        model.addAttribute("allCities", cityService.allCities());
        return "animal-update";
    }

//    @PostMapping("/animal/update/{id}")
//    public String updateAnimal(@PathVariable("id") long id, @ModelAttribute("animalToUpdate") Animal animalToUpdate, Model model){
//        animalService.updateAnimal(animalToUpdate);
//        return "redirect:/animal";
//    }

    @RequestMapping("/admin/animal/update/{id}") //Kopia powyższego kontrollera dla jpg
    public String updateAnimal(@PathVariable("id") long id, @ModelAttribute ("animalToUpdate") @Valid Animal animalToUpdate, BindingResult bindingResult , @RequestParam("image") MultipartFile multipartFile, Model model) throws IOException {

        if (bindingResult.hasErrors()) {
            System.out.println("Validation error found!");
            model.addAttribute("allCities", cityService.allCities());
            return "animal-update";
        }


        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        if( !multipartFile.isEmpty()) {
            animalToUpdate.setPhoto(fileName);
            Animal tempAnimal = animalService.addAnimal(animalToUpdate);
            String uploadDir = "Animal-photos/" + tempAnimal.getId();
            FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
            return "redirect:/admin/animal";
        }
        animalService.updateAnimal(animalToUpdate);
        return "redirect:/admin/animal";
    }



}
