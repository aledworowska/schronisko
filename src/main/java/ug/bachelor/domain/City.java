package ug.bachelor.domain;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import ug.bachelor.domain.enums.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


@Entity
public class City {

    private Long id;
    private String name;

    //@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private ArrayList<Animal> animalsList;


    public City() {
    }

    public City(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Animal> getAnimalsList() {
        return animalsList;
    }

    public void setAnimalsList(ArrayList<Animal> animalsList) {
        this.animalsList = animalsList;
    }
}

