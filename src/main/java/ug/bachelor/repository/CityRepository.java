package ug.bachelor.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ug.bachelor.domain.City;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface CityRepository extends CrudRepository<City, Long> {

}
