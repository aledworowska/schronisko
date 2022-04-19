package ug.bachelor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ug.bachelor.service.AnimalService;

@SpringBootApplication
public class BachelorApplication {

	public static void main(String[] args) {
		SpringApplication.run(BachelorApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner initializeApp(@Autowired AnimalService animalService) {
//		return (args) -> animalService.initDB();
//	}
}


