package ug.bachelor.domain;

import ug.bachelor.domain.enums.Sex;
import ug.bachelor.domain.enums.Species;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.swing.*;

@Entity
public class Animal {

    private Long id;

    private String name;
    private Sex sex;
    private int age;
    private JTextField description;
    private Species species;
    private boolean isReserved;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {return id; }

    public void setId(Long id)  { this.id = id; }

    public Animal(String name, Sex sex, int age, JTextField description, Species species, boolean isReserved) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.description = description;
        this.species = species;
        this.isReserved = isReserved;
    }
}
