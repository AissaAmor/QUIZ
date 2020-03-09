package spring.session.testBackEnd.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Reponse {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String reponse;
    private Boolean correct;
	
	@ManyToOne(cascade = CascadeType.ALL) 
    @JoinColumn(name = "question_id" )
	public Question question ;

	public Reponse() {
		
	}

	public String getReponse() {
		return reponse;
	}

	public void setReponse(String reponse) {
		this.reponse = reponse;
	}

	public Boolean getCorrect() {
		return correct;
	}

	public void setCorrect(Boolean correct) {
		this.correct = correct;
	}

	@JsonIgnore
	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public int getId() {
		return id;
	}

}
