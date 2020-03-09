package spring.session.testBackEnd.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import spring.session.testBackEnd.entities.Quiz;

@Entity
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String question;
	private String type;

	@OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
	private List<Reponse> listReponses = new ArrayList<Reponse>();

	@ManyToOne
	@JoinColumn(name = "quiz_id",referencedColumnName = "id")
	private Quiz quiz;

	public Question() {
		super();
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Reponse> getListReponses() {
		return listReponses;
	}

	public void setListReponses(List<Reponse> listReponses) {
		this.listReponses = listReponses;
	}
	
	@JsonIgnore
	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	public Long getId() {
		return id;
	}
}
