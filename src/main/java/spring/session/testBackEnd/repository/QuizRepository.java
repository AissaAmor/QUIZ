package spring.session.testBackEnd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.session.testBackEnd.entities.Quiz;


@Repository("QuizRepository")
public interface QuizRepository extends JpaRepository<Quiz, Integer> {

}
