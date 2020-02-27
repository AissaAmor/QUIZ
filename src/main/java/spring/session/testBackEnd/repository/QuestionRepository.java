package spring.session.testBackEnd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.session.testBackEnd.entities.Question;

@Repository("QuestionRepository")
public interface QuestionRepository extends JpaRepository<Question, Integer>{

}




