package ug.bachelor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ug.bachelor.domain.User;


public interface UserRepository extends JpaRepository<User,Long> {

}
