package spring.session.testBackEnd.services;

import java.util.List;

import spring.session.testBackEnd.entities.Question;

public interface QuestionService {
	
	public void AjoutQR(Question Questions);
	public void deleteQR(Question Questions);
	public Question getId_Question(Integer id_Question);
//	public List<Reponses> getAll();	 
	public List<Question> GetAll();
	void AjoutlistQuestion(List<Question> Questions);
}
