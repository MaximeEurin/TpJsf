package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.User;

public interface IUserDao {
	
	/**
	 * D�claration des m�thodes
	 * @param us
	 */
	
	public void ajouterUserDao(User us);
	
	public List<User> getAllUserDao();
	
	public User getUserByIdDao(int id_user);
	
	public void supprimerUserDao(User us);
	
	public void modifierUserDao(User us);

	
	
}
