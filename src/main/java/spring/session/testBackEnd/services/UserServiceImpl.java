package spring.session.testBackEnd.services;



import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.session.testBackEnd.entities.User;
import spring.session.testBackEnd.repository.UserRepository;


@Service("UserService")
public class UserServiceImpl implements UserService {

	
	EntityManager em;
	
	@Autowired
	 UserRepository userrepository;

	@Override
	public void AjoutUser(User user) {
		userrepository.save(user);
	}
	
	@Override
	public User loadByUsername(String username) {

		TypedQuery<User> query = (TypedQuery<User>) em
				.createQuery("SELECT u FROM User u WHERE u.username = :username", User.class);
		User user = query.setParameter("username", username).getSingleResult();
		return user;

	}
	
}
