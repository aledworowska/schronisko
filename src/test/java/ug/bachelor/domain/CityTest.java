package ug.bachelor.domain;

import org.junit.jupiter.api.Test;
import ug.bachelor.domain.enums.Sex;
import ug.bachelor.domain.enums.Species;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class CityTest {

    @Test
    void CreateCity(){
        City testCity = new City(1L,"name","address","123456789");

        assertAll("fields",
                () -> assertEquals(1,testCity.getId()),
                () -> assertEquals("name",testCity.getName()),
                () -> assertEquals("address",testCity.getAddress()),
                () -> assertEquals("123456789",testCity.getPhone())
        );
    }

    @Test
    void UpdateCity(){
        City testCity = new City(1L,"name","address","123456789");

        testCity.setId(2L);
        testCity.setName("updateName");
        testCity.setAddress("updateAddress");
        testCity.setPhone("987654321");

        assertAll("fields",
                () -> assertEquals(2,testCity.getId()),
                () -> assertEquals("updateName",testCity.getName()),
                () -> assertEquals("updateAddress",testCity.getAddress()),
                () -> assertEquals("987654321",testCity.getPhone())
        );
    }



}
