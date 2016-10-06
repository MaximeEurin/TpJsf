package fr.adaming.model;

public class Agent {
	
	private int id_agent;
	private String mail;
	private String mdp;
	
	/**
	 * Constructeur sans paramètres
	 */
	public Agent() {
		super();
	}
	
	/**
	 * 
	 * Constructeur avec paramètres sans id
	 * @param mail
	 * @param mdp
	 */
	public Agent(String mail, String mdp) {
		super();
		this.mail = mail;
		this.mdp = mdp;
	}

	/**
	 * Constructeurs avec tous les paramètres
	 * @param id_agent
	 * @param mail
	 * @param mdp
	 */
	public Agent(int id_agent, String mail, String mdp) {
		super();
		this.id_agent = id_agent;
		this.mail = mail;
		this.mdp = mdp;
	}
	
	/**
	 * 
	 * Getter et Setter
	 * @return
	 */

	public int getId_agent() {
		return id_agent;
	}

	public void setId_agent(int id_agent) {
		this.id_agent = id_agent;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	
	
	@Override
	public String toString() {
		return "Agent [id_agent=" + id_agent + ", mail=" + mail + ", mdp="
				+ mdp + "]";
	}
	
	

}
