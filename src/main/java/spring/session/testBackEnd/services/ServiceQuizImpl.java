package spring.session.testBackEnd.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.session.testBackEnd.entities.Question;
import spring.session.testBackEnd.entities.Quiz;
import spring.session.testBackEnd.repository.QuizRepository;

@Service("ServiceQuiz")
public class ServiceQuizImpl implements ServiceQuiz {

	@Autowired
	QuizRepository quizrepository;
	
	@Override
	public void AjoutQuiz(Quiz quiz) {
		quizrepository.save(quiz);
	}

	@Override
	public List<Quiz> getAll() {
		
		return quizrepository.findAll();
	}

	@Override
	public void  AjoutlistQuiz(List<Quiz> quiz) {
		quizrepository.saveAll(quiz);
	}

	@Override
	public Quiz getQuizbyId(Integer id) {
		
		return quizrepository.findById(id).get();
	}

	@Override
	public void QuizCandidat(Quiz quiz) {
		quizrepository.save(quiz);
		
	}
}
