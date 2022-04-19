package ug.bachelor.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ug.bachelor.domain.Animal;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface AnimalRepository extends CrudRepository<Animal, Long> {
}
