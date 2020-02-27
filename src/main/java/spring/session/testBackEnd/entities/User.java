package spring.session.testBackEnd.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id_User;
	private String nom;
	private String prenom;
	@NotNull
	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getId_User() {
		return Id_User;
	}
	public void setId_User(int id_User) {
		Id_User = id_User;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public User(int id_User, String nom, String prenom, @NotNull String username, String password) {
		super();
		Id_User = id_User;
		this.nom = nom;
		this.prenom = prenom;
		this.username = username;
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [Id_User=" + Id_User + ", nom=" + nom + ", prenom=" + prenom + ", username=" + username
				+ ", password=" + password + "]";
	}
	
	
	
}
