package spring.session.testBackEnd.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.session.testBackEnd.entities.Question;
import spring.session.testBackEnd.repository.QuestionRepository;

@Service("QuestionService") 
public class QuestionServicelmpl implements QuestionService { 
	
	
	@Autowired
	QuestionRepository questionrepository;   
	
	
	@Override
	public List <Question> GetAll() { 
		// TODO Auto-generated method stub
		return questionrepository.findAll();
		
	}
	
	
	@Override
	public Question getId_Question(Integer id_Question) {
		// TODO Auto-generated method stub
		return questionrepository.getOne(id_Question);
	}

	
	@Override
	public void  AjoutlistQuestion(List<Question> Questions) {
		questionrepository.saveAll(Questions);
	}

	
	
	@Override
	public void deleteQR(Question Questions) { 
		// TODO Auto-generated method stub
		
	}


	@Override
	public void AjoutQR(Question Questions) {
		// TODO Auto-generated method stub
		
	}

}
