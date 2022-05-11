package ug.bachelor.domain;

import org.hibernate.validator.constraints.Range;
import ug.bachelor.domain.enums.Sex;
import ug.bachelor.domain.enums.Species;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.*;

@Entity
@Table(name = "animal")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotEmpty(message = "Name can not be empty!")
    @Size(min = 1, message = "Name must be at least 1 character!")
    @Size(max = 20, message = "Name must be less then 20 characters!")
    private String name;

    private Sex sex;

    @NotNull(message = "Age can not be null!")//to chyba nie działa
    @Range(min=1, max=50, message ="Age must be withing 1-50" )
    private int age;


    @Size(max = 255, message = "Description must be withing 0-255 characters!")
    private String description;

    private Species species;

    private boolean isReserved;


    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    private City city;

    @Column(nullable = true, length = 64)
    private String photo;

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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Animal(Long id, String name, Sex sex, int age, String description, Species species, boolean isReserved, String photo, City city) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.description = description;
        this.species = species;
        this.isReserved = isReserved;
        this.photo = photo;
        this.city=city;
    }

    public Animal(String name, Sex sex, int age, String description, Species species, boolean isReserved, String photo, City city) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.description = description;
        this.species = species;
        this.isReserved = isReserved;
        this.photo = photo;
        this.city=city;
    }

    @Transient
    public String getPhotosImagePath() {
        if (photo == null || id == null) return null;

        return "/Animal-photos/" + id + "/" + photo;
    }

//
//    public Animal(Long id, String name, Sex sex, int age, String description, Species species, boolean isReserved) {
//        this.id = id;
//        this.name = name;
//        this.sex = sex;
//        this.age = age;
//        this.description = description;
//        this.species = species;
//        this.isReserved = isReserved;
//    }
//
//    public Animal(String name, Sex sex, int age, String description, Species species, boolean isReserved, City city  ) {
//        this.name = name;
//        this.sex = sex;
//        this.age = age;
//        this.description = description;
//        this.species = species;
//        this.isReserved = isReserved;
//        this.city = city;
//    }


}
