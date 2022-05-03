package ug.bachelor.domain;

import ug.bachelor.domain.enums.Sex;
import ug.bachelor.domain.enums.Species;
import ug.bachelor.domain.City;


import javax.persistence.*;

@Entity
@Table(name = "animal")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    private Sex sex;

    private int age;

    private String description;

    private Species species;

    private boolean isReserved;


    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    private City city;


//    @Column(nullable = true, length = 64)
//    private String image;

    public Animal() {
    }


    public Long getId() {return id; }

    public void setId(Long id)  { this.id = id; }

    public String getName() {return name;}

    public Sex getSex() {return sex;}

    public int getAge() {return age;}

    public String getDescription() {return description;}

    public Species getSpecies() {return species;}

    public boolean isReserved() {return isReserved;}

    public City getCity() {
        return city;
    }


    public void setName(String name) {this.name = name;}

    public void setSex(Sex sex) {this.sex = sex;}

    public void setAge(int age) { this.age = age;}

    public void setDescription(String description) {this.description = description;}

    public void setSpecies(Species species) {this.species = species;}

    public void setReserved(boolean reserved) {isReserved = reserved;}

    public void setCity(City city) {
        this.city = city;
    }

//    public String getImage() {
//        return image;
//    }

   // public void setImage(String image) {
//        this.image = image;
//    }

//    public Animal(Long id, String name, Sex sex, int age, String description, Species species, boolean isReserved, String image) {
//        this.id = id;
//        this.name = name;
//        this.sex = sex;
//        this.age = age;
//        this.description = description;
//        this.species = species;
//        this.isReserved = isReserved;
//        this.image = image;
//    }
//
//    public Animal(String name, Sex sex, int age, String description, Species species, boolean isReserved, String image) {
//        this.name = name;
//        this.sex = sex;
//        this.age = age;
//        this.description = description;
//        this.species = species;
//        this.isReserved = isReserved;
//        this.image = image;
//    }

    public Animal(Long id, String name, Sex sex, int age, String description, Species species, boolean isReserved) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.description = description;
        this.species = species;
        this.isReserved = isReserved;
    }

    public Animal(String name, Sex sex, int age, String description, Species species, boolean isReserved, City city  ) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.description = description;
        this.species = species;
        this.isReserved = isReserved;
        this.city = city;
    }
}
