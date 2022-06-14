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
    @Size(max = 55, message = "Name must be less then 55 characters!")
    private String name;


    private String address;

    @Pattern(regexp = "^(?=.*\\d).{9,12}$", message = "Not valid phone number!")
    private String phone;

    @OneToMany(mappedBy = "city", fetch = FetchType.LAZY)
    private List<Animal> animalsList;


    public City() {
    }

    public City(String name, String address, String phone) {

        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public City(Long id,String name, String address, String phone) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
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

    public String getAddress() { return address; }

    public String getPhone() { return phone; }

    public void setName(String name) {
        this.name = name;
    }

    public List<Animal> getAnimalsList() {
        return animalsList;
    }

    public void setAddress(String address) {this.address = address;}

    public void setPhone(String phone) {this.phone = phone;}

    public void setAnimalsList(List<Animal> animalsList) {
        this.animalsList = animalsList;
    }
}

