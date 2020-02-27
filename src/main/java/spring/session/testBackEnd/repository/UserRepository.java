package spring.session.testBackEnd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.session.testBackEnd.entities.User;

@Repository("UserRepository")
public interface UserRepository extends JpaRepository<User, Integer>{

}




