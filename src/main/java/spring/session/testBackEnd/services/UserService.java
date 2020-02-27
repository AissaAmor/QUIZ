package spring.session.testBackEnd.services;

import spring.session.testBackEnd.entities.User;

public interface UserService {

	public void AjoutUser(User user);

	public User loadByUsername(String username);

}
