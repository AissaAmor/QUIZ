package spring.session.testBackEnd.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import spring.session.testBackEnd.entities.Reponse;
import spring.session.testBackEnd.repository.ReponseRepository;
import spring.session.testBackEnd.services.ReponseService;
import spring.session.testBackEnd.services.QuestionService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/Reponse")
public class ReponseController {
	
	
	@Autowired
	ReponseRepository reponseRepository;

	@Autowired
	ReponseService reponseService;

	
	@Autowired
	QuestionService QuestionService;

	
	@RequestMapping(path = "/all", method = RequestMethod.GET)
	public List<Reponse> getAll() {
		System.out.println("here");

		return reponseService.getAll();
	}

	
	@RequestMapping(path = "/addReponse", method = RequestMethod.GET)
	public void AjouterReponses(Reponse reponse) {
		reponseRepository.save(reponse);
	}

	
	@RequestMapping(path = "/delete/{id}", method = RequestMethod.DELETE)
	public void DeleteReponses(@PathVariable("id") Integer id) {
		Reponse reponse = reponseService.getId_reponses(id);

		System.out.println(reponse);
		reponseService.DeleteReponses(reponse);
	}
}
