package ug.bachelor.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ug.bachelor.domain.Animal;
import ug.bachelor.domain.City;
import ug.bachelor.repository.CityRepository;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class CityService {
    private final CityRepository cityRepository;


    @Autowired
    public CityService(CityRepository cityRepository) {this.cityRepository = cityRepository; }

    public Iterable<City> allCities() { return cityRepository.findAll(); }

    public City getCity(long id) {return cityRepository.findById(id).orElse(null); }

    public City addCity(City city) {return cityRepository.save(city);}

    public City updateCity(City city) {

        City cityToUpdate = cityRepository.findById( city.getId()).orElse(null);
        cityToUpdate.setName(city.getName());
        cityToUpdate.setAnimalsList(city.getAnimalsList());

        return cityRepository.save(cityToUpdate);
    }

    public void deleteCity(City city) { cityRepository.deleteById(city.getId());}








}