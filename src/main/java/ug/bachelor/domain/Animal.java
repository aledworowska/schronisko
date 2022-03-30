package ug.bachelor.domain;

import ug.bachelor.domain.enums.Sex;
import ug.bachelor.domain.enums.Species;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.swing.*;

public class Animal {

    private String id;

    private String name;
    private Sex sex;
    private int age;
    private String description;
    //private JTextField description;
    private Species species;
    private boolean isReserved;

    public Animal() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public String getId() {return id; }

    public void setId(String id)  { this.id = id; }

    public String getName() {return name;}

    public Sex getSex() {return sex;}

    public int getAge() {return age;}

    //public JTextField getDescription() {return description;}
    public String getDescription() {return description;}

    public Species getSpecies() {return species;}

    public boolean isReserved() {return isReserved;}

    public Animal(String name, Sex sex, int age, /*JTextField description*/ String description, Species species, boolean isReserved) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.description = description;
        this.species = species;
        this.isReserved = isReserved;
    }
    public Animal(String id, String name, Sex sex, int age, /*JTextField description*/ String description, Species species, boolean isReserved) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.description = description;
        this.species = species;
        this.isReserved = isReserved;
    }
}
