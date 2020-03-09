package spring.session.testBackEnd.Controller;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import spring.session.testBackEnd.entities.Quiz;
import spring.session.testBackEnd.entities.Reponse;
import spring.session.testBackEnd.entities.Question;
import spring.session.testBackEnd.services.QuestionService;
import spring.session.testBackEnd.services.ReponseService;
import spring.session.testBackEnd.services.ServiceQuiz;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/quiz")
public class QuizController {

	@Autowired
	ServiceQuiz servicequiz;
	
	@Autowired
	QuestionService questionservice;
	
	@Autowired
	ReponseService reponseservice;
	

	int score;

	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public void addQuiz(@RequestBody Quiz quiz){
		quiz.getQuestion().forEach(question -> {
			question.setQuiz(quiz);
			question.getListReponses().forEach(reponse -> reponse.setQuestion(question));
		});
		servicequiz.AjoutlistQuiz(Collections.singletonList(quiz));
	}
//		for (int i = 0; i < quiz.getQuestion().size(); i++) {
//		Question question = quiz.getQuestion().get(i);
//		question.setQuiz(quiz);
//		
//		for(int j = 0 ; j < question.getList_reponses().size() ; j++) {
//			Reponse reponse = question.getList_reponses().get(j);
//				reponse.setQuestion(question);
//		}
//	}
//}

//	
	@PutMapping("/getReponses")
	@ResponseBody
	ResponseEntity<?> editCoach(@RequestBody Quiz newQuiz) {
		servicequiz.QuizCandidat(newQuiz);
		return new ResponseEntity<>("update done", HttpStatus.ACCEPTED);

	}
	
	
	@RequestMapping(path = "/calculQuiz" , method = RequestMethod.GET)
	public int getQuiz(Quiz quiz) {
		
		quiz.getQuestion().forEach(question -> {
			question.getQuiz();
			question.getListReponses().forEach(reponse -> {
				if(reponse.getCorrect()) {
					System.out.println(reponse.getReponse() +"/"+reponse.getCorrect());
					this.score = this.score + 3;
				}else {
					this.score = this.score - 1 ;
				}
			});	
		});
		if(this.score<=0) this.score = 0;
	return this.score;
	}
}
	
	





