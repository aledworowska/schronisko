package ug.bachelor.domain;

import ug.bachelor.domain.enums.Sex;
import ug.bachelor.domain.enums.Species;


import javax.persistence.*;

@Entity
@Table(name = "animal")
public class Animal {

    private Long id;
    private String name;
    private Sex sex;
    private int age;
    private String description;
    private Species species;
    private boolean isReserved;




    public Animal() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {return id; }

    public void setId(Long id)  { this.id = id; }

    public String getName() {return name;}

    public Sex getSex() {return sex;}

    public int getAge() {return age;}

    public String getDescription() {return description;}

    public Species getSpecies() {return species;}

    public boolean isReserved() {return isReserved;}


    public void setName(String name) {this.name = name;}

    public void setSex(Sex sex) {this.sex = sex;}

    public void setAge(int age) { this.age = age;}

    public void setDescription(String description) {this.description = description;}

    public void setSpecies(Species species) {this.species = species;}

    public void setReserved(boolean reserved) {isReserved = reserved;}

    public Animal(String name, Sex sex, int age,String description, Species species, boolean isReserved) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.description = description;
        this.species = species;
        this.isReserved = isReserved;
    }
    public Animal(Long id, String name, Sex sex, int age, String description, Species species, boolean isReserved) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.description = description;
        this.species = species;
        this.isReserved = isReserved;
    }
}
