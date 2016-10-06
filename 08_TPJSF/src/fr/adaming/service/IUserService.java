package fr.adaming.service;

import java.util.List;

import fr.adaming.model.User;

public interface IUserService {
	
public void ajouterUserService(User us);
	
	public List<User> getAllUserService();
	
	public User getUserByIdService(int id_user);
	
	public void supprimerUserService(User us);
	
	public void modifierUserService(User us);
	
}
