package spring.session.testBackEnd.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.session.testBackEnd.entities.Reponse;
import spring.session.testBackEnd.repository.ReponseRepository;

@Service("ReponseService")
public class ReponseServiceImpl implements ReponseService {

	@PersistenceContext
	EntityManager em;
	
	@Autowired
	ReponseRepository reponseRepo;



	@Override
	public void AjoutRep(Reponse reponse) {
		reponseRepo.save(reponse);
	}

	@Override
	public List<Reponse> getAll() {
		return reponseRepo.findAll();
	}
}
