package spring.session.testBackEnd.services;

import java.util.List;

import spring.session.testBackEnd.entities.Reponse;
import spring.session.testBackEnd.entities.User;

public interface ReponseService {

    public List<Reponse>getAll(); 
	
	public Reponse getId_reponses(Integer id);
	
	public void  AjouterReponses(Reponse Reponse);
	
	public void DeleteReponses(Reponse Reponse);
}
