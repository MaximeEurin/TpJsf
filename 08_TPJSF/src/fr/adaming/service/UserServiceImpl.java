package fr.adaming.service;

import java.util.List;

import fr.adaming.dao.IUserDao;
import fr.adaming.dao.UserDaoImpl;
import fr.adaming.model.User;

public class UserServiceImpl implements IUserService {
	
	private IUserDao userDao= new UserDaoImpl();
	
	@Override
	public void ajouterUserService(User us) {
		
		userDao.ajouterUserDao(us) ;
		
	}

	@Override
	public List<User> getAllUserService() {
		
		return userDao.getAllUserDao();
	}

	@Override
	public User getUserByIdService(int id_user) {
		return userDao.getUserByIdDao(id_user);
	}

	@Override
	public void supprimerUserService(User us) {
		userDao.supprimerUserDao(us);
		
	}

	@Override
	public void modifierUserService(User us) {
		userDao.modifierUserDao(us);
		
	}

}
