package ug.bachelor.domain;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" , nullable = false)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "city", orphanRemoval = true, fetch = FetchType.LAZY)
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

