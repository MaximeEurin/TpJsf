package fr.adaming.managedBeans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import fr.adaming.model.User;
import fr.adaming.service.IUserService;
import fr.adaming.service.UserServiceImpl;

@ManagedBean(name="userMB")
@ViewScoped
public class UserManagedBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	IUserService userService= new UserServiceImpl();
	
	private int id;
	private String nom;
	private String prenom;
	private String mail;
	private String password;
	
	/**
	 * 
	 */
	public UserManagedBean() {

	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * @param mail the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	

	public String ajouter(){
		
		User us=new User(nom, prenom, mail, password);
		
		userService.ajouterUserService(us);
		return "accueil";
	}
	
	public String modifier(){
		
		User us=new User(id, nom, prenom, mail, password);
		
		userService.modifierUserService(us);
		
		return "accueil";
		
	}
	
	public String supprimer(){
		
		User us=new User();
		
		us.setId(id);
		
		userService.supprimerUserService(us);
		
		return "accueil";
	}


	
	
	
	

}
