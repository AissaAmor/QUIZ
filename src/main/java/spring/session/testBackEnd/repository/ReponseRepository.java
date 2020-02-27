package spring.session.testBackEnd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.session.testBackEnd.entities.Reponse;

@Repository("ReponseRepository")
public interface ReponseRepository extends JpaRepository<Reponse, Integer>{

}




