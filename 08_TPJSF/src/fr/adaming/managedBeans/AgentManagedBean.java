package fr.adaming.managedBeans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import fr.adaming.model.User;
import fr.adaming.service.AgentServiceImpl;
import fr.adaming.service.IAgentService;
import fr.adaming.service.IUserService;
import fr.adaming.service.UserServiceImpl;

@ManagedBean(name="agentMB")
@ViewScoped
public class AgentManagedBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String mail;
	private String password;
	private List<User> listUsers;
	
	
	//instanciation d'un objet UserService pour utiliser ses méthodes
	IAgentService agentService=new AgentServiceImpl();
	IUserService userService=new UserServiceImpl();
	
	/**
	 * 
	 */
	public AgentManagedBean() {
		listUsers=userService.getAllUserService();
	}
	
	
	/**
	 * @return the listUsers
	 */
	public List<User> getListUsers() {
		return listUsers;
	}


	/**
	 * @param listUsers the listUsers to set
	 */
	public void setListUsers(List<User> listUsers) {
		this.listUsers = listUsers;
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
	
	
	public String connexion(){
		
		int verif=agentService.isExistService(mail, password);
		
		if(verif!=1){
			
			return "erreur";
			
		}else{
			listUsers=userService.getAllUserService();
			return "accueil";
		}

		
	}
	
	

}
