package ug.bachelor.domain;

import org.junit.jupiter.api.Test;
import ug.bachelor.domain.enums.Sex;
import ug.bachelor.domain.enums.Species;

import static org.junit.jupiter.api.Assertions.*;

public class AnimalTest {

    @Test
    void createAnimal() {
        City testCity = new City("name","address","123456789");
        Animal testAnimal = new Animal(1L,"name", Sex.FEMALE,5,"sample description", Species.CAT,true,"photo.jpg",testCity);
        assertAll("fields",
                () -> assertEquals(1,testAnimal.getId()),
                () -> assertEquals("name",testAnimal.getName()),
                () -> assertEquals(Sex.FEMALE,testAnimal.getSex()),
                () -> assertEquals(5,testAnimal.getAge()),
                () -> assertEquals("sample description",testAnimal.getDescription()),
                () -> assertEquals(Species.CAT,testAnimal.getSpecies()),
                () -> assertEquals(true,testAnimal.isReserved()),
                () -> assertEquals("photo.jpg",testAnimal.getPhoto()),
                () -> assertEquals(testCity,testAnimal.getCity())
                );
    }

    @Test
    void updateAnimal() {
        City testCity = new City("name","address","123456789");
        City updateCity = new City("updateName","updateAddress","987654321");
        Animal testAnimal = new Animal(1L,"name", Sex.FEMALE,5,"sample description", Species.CAT,true,"photo.jpg",testCity);

        testCity.setName("updateName");
        testCity.setAddress("updateAddress");
        testCity.setPhone("987654321");
        testAnimal.setId(2L);
        testAnimal.setName("updateName");
        testAnimal.setSex(Sex.MALE);
        testAnimal.setAge(2);
        testAnimal.setDescription("updateDescription");
        testAnimal.setSpecies(Species.DOG);
        testAnimal.setReserved(false);
        testAnimal.setPhoto("updatePhoto.jpg");
        testAnimal.setCity(updateCity);

        assertAll("fields",
                () -> assertEquals(2,testAnimal.getId()),
                () -> assertEquals("updateName",testAnimal.getName()),
                () -> assertEquals(Sex.MALE,testAnimal.getSex()),
                () -> assertEquals(2,testAnimal.getAge()),
                () -> assertEquals("updateDescription",testAnimal.getDescription()),
                () -> assertEquals(Species.DOG,testAnimal.getSpecies()),
                () -> assertEquals(false,testAnimal.isReserved()),
                () -> assertEquals("updatePhoto.jpg",testAnimal.getPhoto()),
                () -> assertEquals(updateCity,testAnimal.getCity())
        );
    }






}