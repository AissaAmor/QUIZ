package spring.session.testBackEnd.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_Question;
    private String question;
    private String option_1;
    private String option_2;
    private String option_3;
    private String option_4;

//    @OneToMany(fetch = FetchType.EAGER,mappedBy = "question")
    private List<Reponse> list_reponses = new ArrayList<Reponse>();
    public Long getId() {
		return id_Question;
	}
	public void setId(Long id) {
		this.id_Question = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getOption_1() {
		return option_1;
	}
	public void setOption_1(String option_1) {
		this.option_1 = option_1;
	}
	public String getOption_2() {
		return option_2;
	}
	public void setOption_2(String option_2) {
		this.option_2 = option_2;
	}
	public String getOption_3() {
		return option_3;
	}
	public void setOption_3(String option_3) {
		this.option_3 = option_3;
	}
	public String getOption_4() {
		return option_4;
	}
	public void setOption_4(String option_4) {
		this.option_4 = option_4;
	}
	
	
	public List<Reponse> getList_reponses() {
		return list_reponses;
	}
	public void setList_reponses(List<Reponse> list_reponses) {
		this.list_reponses = list_reponses;
	}
	public Question(Long id, String question, String option_1, String option_2, String option_3, String option_4,
			int answer) {
		super();
		this.id_Question = id;
		this.question = question;
		this.option_1 = option_1;
		this.option_2 = option_2;
		this.option_3 = option_3;
		this.option_4 = option_4;
	}
	@Override
	public String toString() {
		return "Question [id=" + id_Question + ", question=" + question + ", option_1=" + option_1 + ", option_2=" + option_2
				+ ", option_3=" + option_3 + ", option_4=" + option_4 + "]";
	}
    
    
}
