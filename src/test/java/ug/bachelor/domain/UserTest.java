package ug.bachelor.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    @Test
    void CreateUser(){
        User testUser = new User(1L,"testName","testUserName","test@test.pl","password");

        assertAll("fields",
                () -> assertEquals(1,testUser.getId()),
                () -> assertEquals("testName",testUser.getName()),
                () -> assertEquals("testUserName",testUser.getUserName()),
                () -> assertEquals("test@test.pl",testUser.getEmail()),
                () -> assertEquals("password",testUser.getPassword())
        );
    }

    @Test
    void UpdateUser(){
        User testUser = new User(1L,"testName","testUserName","test@test.pl","password");

        testUser.setId(2L);
        testUser.setName("updateName");
        testUser.setUserName("updateUserName");
        testUser.setEmail("update@test.pl");
        testUser.setPassword("update");

        assertAll("fields",
                () -> assertEquals(2,testUser.getId()),
                () -> assertEquals("updateName",testUser.getName()),
                () -> assertEquals("updateUserName",testUser.getUserName()),
                () -> assertEquals("update@test.pl",testUser.getEmail()),
                () -> assertEquals("update",testUser.getPassword())
        );
    }

}
