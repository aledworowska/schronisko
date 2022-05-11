package ug.bachelor.domain;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import javax.validation.constraints.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" , nullable = false)
    private Long id;


    @NotEmpty(message = "Name can not be empty!")
    @Size(min = 1, message = "Name must be at least 1 character!")
    @Size(max = 20, message = "Name must be less then 20 characters!")
    private String name;

    @OneToMany(mappedBy = "city", fetch = FetchType.LAZY)
    private List<Animal> animalsList;


    public City() {
    }

    public City(String name) {
        this.name = name;
    }


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

    public List<Animal> getAnimalsList() {
        return animalsList;
    }

    public void setAnimalsList(List<Animal> animalsList) {
        this.animalsList = animalsList;
    }
}

