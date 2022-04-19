package ug.bachelor.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ug.bachelor.domain.City;
import ug.bachelor.service.CityService;


@Controller
public class WebCityController {
    private final CityService cityService;


    public WebCityController(CityService cityService) {this.cityService = cityService;}



    @GetMapping("/city")
    public String cities(Model model){
        model.addAttribute("allCitiesFromList", cityService.allCities());
        return "city-all";
    }

    @GetMapping("/city/add")
    public String addNewCity(Model model){
        model.addAttribute("cityToAdd", new City());
        return "city-add";
    }

    @PostMapping("/city")
    public String addNewCity(@ModelAttribute("allCitiesFromList") City city) {
        cityService.addCity(city);
        return "redirect:/city";
    }

    @GetMapping("/city/delete/{id}")
    public String deleteCity(@PathVariable("id") long id, Model model) {
        cityService.deleteCity(cityService.getCity(id));
        model.addAttribute("allCities",cityService.allCities());
        return "redirect:/city";
    }
    @GetMapping("/city/update/{id}")
    public String updateCity(@PathVariable("id") long id, Model model){
        City cityToUpdate = cityService.getCity(id);
        model.addAttribute("cityToUpdate",cityToUpdate);
        return "city-update";
    }

    @PostMapping("/city/update/{id}")
    public String updateCity(@PathVariable("id") long id, @ModelAttribute("cityToUpdate") City cityToUpdate, Model model){
        cityService.updateCity(cityToUpdate);
        return "redirect:/city";
    }

}
