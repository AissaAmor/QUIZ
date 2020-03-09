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
	public List<Reponse> getAll() {
		return reponseRepo.findAll();

	}

	@Override
	public Reponse getId_reponses(Integer id) {
		return reponseRepo.getOne(id);

	}

	@Override
	public void AjouterReponses(Reponse Reponse) {
		reponseRepo.save(Reponse);

	}

	@Override
	public void DeleteReponses(Reponse Reponse) {
		em.remove(Reponse);

	}

}
