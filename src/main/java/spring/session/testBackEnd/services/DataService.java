package spring.session.testBackEnd.services;


import org.springframework.stereotype.Service;

import spring.session.testBackEnd.entities.Question;
import spring.session.testBackEnd.entities.Reponse;

@Service("DataService")

public class DataService {

	public Question q;
	public Reponse [] rep;
}
