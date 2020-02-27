package spring.session.testBackEnd.services;

import java.util.List;

import spring.session.testBackEnd.entities.Reponse;
import spring.session.testBackEnd.entities.User;

public interface ReponseService {

	public void AjoutRep(Reponse reponse);

	public List <Reponse> getAll();
}
