package spring.session.testBackEnd.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import spring.session.testBackEnd.entities.Question;
import spring.session.testBackEnd.repository.QuestionRepository;
import spring.session.testBackEnd.repository.ReponseRepository;
import spring.session.testBackEnd.services.DataService;
import spring.session.testBackEnd.services.QuestionService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/Questions")
public class QuestionController {

	@Autowired
	QuestionRepository questionrepository;
	
	
	@Autowired
	ReponseRepository reponseRepository;
	
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
			reponseRepository.save(data.rep[i]);
		}
		System.out.println(data.rep.length);
	}
	
//	@RequestMapping(path ="/calcul" , method = RequestMethod.POST)
//	public Integer calculQuiz(@RequestBody Question  dataserv) {
//		
//		for(i=0;i<dataserv.getPayload().)
//		return null;	
//	}
	
    
    @RequestMapping(path = "/delete/{id}", method = RequestMethod.DELETE)
   	public void deleteQR(@PathVariable("id") Integer id ) {
    	
	 Question question = questionservice.getId_Question(id);
	 questionservice.deleteQR(question);	   		
   	}
 @RequestMapping(path = "/display", method = RequestMethod.GET)
	public List<Question> GetAll() {
		System.out.println("here");
		return questionservice.GetAll();
	}
}
