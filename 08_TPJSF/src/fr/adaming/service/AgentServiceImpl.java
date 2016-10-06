package fr.adaming.service;

import fr.adaming.dao.AgentDaoImpl;
import fr.adaming.dao.IAgentDao;

public class AgentServiceImpl implements IAgentService{
	
	/**
	 * instancie pour appeler les méthodes de l'interface
	 */
	IAgentDao agentDao=new AgentDaoImpl();

	@Override
	public int isExistService(String login, String mdp) {
		return agentDao.isExistDao(login, mdp);
	}

}
