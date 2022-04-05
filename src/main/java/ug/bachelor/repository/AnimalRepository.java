package ug.bachelor.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ug.bachelor.domain.Animal;

@Repository
public interface AnimalRepository extends CrudRepository<Animal, Long> {
}
