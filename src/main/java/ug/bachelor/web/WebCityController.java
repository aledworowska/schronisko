package ug.bachelor.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ug.bachelor.domain.City;
import ug.bachelor.service.AnimalService;
import ug.bachelor.service.CityService;

import javax.validation.Valid;


@Controller
public class WebCityController {
    private final CityService cityService;
    private final AnimalService animalService;


    public WebCityController(CityService cityService, AnimalService animalService) {
        this.cityService = cityService;
        this.animalService = animalService;
    }

    @GetMapping("/city")
    public String cities(Model model){
        model.addAttribute("allCitiesFromList", cityService.allCities());
        return "city-all";
    }

    @GetMapping("/admin/city")
    public String citiesAdmin(Model model){
        model.addAttribute("allCitiesFromList", cityService.allCities());
        return "city-all-admin";
    }

    @GetMapping("/city/{id}")
    public String animalsFromCity(@PathVariable("id") long id,Model model){
        model.addAttribute("animalsFromCity", cityService.getAnimalFromCity(id));
        model.addAttribute("city", cityService.getCity(id));
        return "animals-from-city";
    }
    @GetMapping("/admin/city/{id}")
    public String animalsFromCityAdmin(@PathVariable("id") long id,Model model){
        model.addAttribute("animalsFromCity", cityService.getAnimalFromCity(id));
        model.addAttribute("city", cityService.getCity(id));
        return "animals-from-city-admin";
    }


    @GetMapping("/admin/city/add")
    public String addNewCity(Model model){
        model.addAttribute("cityToAdd", new City());
        return "city-add";
    }

    @PostMapping("/admin/city")
    public String addNewCity(@ModelAttribute("cityToAdd") @Valid City city, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            System.out.println("Validation error found!");
            return "city-add";
        }

        cityService.addCity(city);
        return "redirect:/admin/city";
    }

    @GetMapping("/admin/city/delete/{id}")
    public String deleteCity(@PathVariable("id") long id, Model model) {
        cityService.deleteCity(cityService.getCity(id));
        model.addAttribute("allCities",cityService.allCities());
        return "redirect:/admin/city";
    }
    @GetMapping("/admin/city/update/{id}")
    public String updateCity(@PathVariable("id") long id, Model model){
        City cityToUpdate = cityService.getCity(id);
        model.addAttribute("cityToUpdate",cityToUpdate);
        return "city-update";
    }

    @PostMapping("/admin/city/update/{id}")
    public String updateCity(@PathVariable("id") long id, @ModelAttribute("cityToUpdate") @Valid City cityToUpdate,BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            System.out.println("Validation error found!");
            return "redirect:/admin/city/update/{id}";
        }

        cityService.updateCity(cityToUpdate);
        return "redirect:/admin/city";
    }


}
