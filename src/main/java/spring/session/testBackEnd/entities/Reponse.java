package spring.session.testBackEnd.entities;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Reponse {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_Reponse;
	private String reponse;
	private String correct;
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "id_Question")
	public Question question ;
	public int getId_Reponse() {
		return id_Reponse;
	}
	public void setId_Reponse(int id_Reponse) {
		this.id_Reponse = id_Reponse;
	}
	public String getReponse() {
		return reponse;
	}
	public void setReponse(String reponse) {
		this.reponse = reponse;
	}
	public String getCorrect() {
		return correct;
	}
	public void setCorrect(String correct) {
		this.correct = correct;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public Reponse(int id_Reponse, String reponse, String correct, Question question) {
		super();
		this.id_Reponse = id_Reponse;
		this.reponse = reponse;
		this.correct = correct;
		this.question = question;
	}
	@Override
	public String toString() {
		return "Reponse [id_Reponse=" + id_Reponse + ", reponse=" + reponse + ", correct=" + correct + ", question="
				+ question + "]";
	}
	
	
}
