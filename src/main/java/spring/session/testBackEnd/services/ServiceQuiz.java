package spring.session.testBackEnd.services;

import java.util.List;

import spring.session.testBackEnd.entities.Quiz;

public interface ServiceQuiz {

	public void AjoutQuiz(Quiz quiz);
	public void QuizCandidat(Quiz quiz);
	public Quiz getQuizbyId(Integer id);
	List <Quiz> getAll() ;
	 void AjoutlistQuiz(List<Quiz> quiz);
}
