package spring.session.testBackEnd.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.session.testBackEnd.entities.Question;
import spring.session.testBackEnd.repository.QuestionRepository;
import spring.session.testBackEnd.repository.ReponseRepository;
import spring.session.testBackEnd.services.DataService;
import spring.session.testBackEnd.services.QuestionService;

public class QuizController {

	@Autowired
	QuestionRepository questionrepository;
	
	@Autowired
	QuestionService questionservice;
	
	@Autowired
	DataService dataservice;
	
	@Autowired
	ReponseRepository reponseRepo;
	@RequestMapping(path = "/add" , method = RequestMethod.POST)
	public void saveQuiz(@RequestBody  DataService data) {
		questionrepository.save(data.q);
		int i=0;
		for(i=0; i<data.rep.length;i++) {
			data.rep[i].question = data.q;
			reponseRepo.save(data.rep[i]);
		}
	}
}
