package fr.adaming.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class AgentDaoImpl implements IAgentDao{
	
	public static final String url="jdbc:mysql://localhost:3306/dbuser";
	public static final String userDb="root";
	public static final String passwordDb="root";
	
	private Connection cx=null;
	private PreparedStatement ps=null;
	
	@Override
	public int isExistDao(String login, String mdp){
		
		
		try {
			/**
			 * Chargement du driver
			 */
			Class.forName("com.mysql.jdbc.Driver");
			
			/**
			 * Creation de la connexion
			 */
			cx=DriverManager.getConnection(url, userDb, passwordDb);
			
			/**
			 * Ecrire la requete
			 */
			String sqlReq="SELECT count(id) from agent where mail=? and password=?";
			
			/**
			 * Creer un ps
			 */
			ps=cx.prepareStatement(sqlReq);
			
			/**
			 * Passer les valeurs des paramètres de la requete
			 */
			ps.setString(1, login);
			ps.setString(2, mdp);
			
			/**
			 * Envoyer la requete et récupérer le résultat
			 */
			
			ResultSet rs=ps.executeQuery();
			
			/**
			 * Utilisation du resultat
			 */
			rs.next();
			return rs.getInt(1);
			
						
		} catch (ClassNotFoundException e) {
			System.out.println("Exception ClassNotFound");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Exception SQL");
			e.printStackTrace();
		}finally{
			if(cx!=null){
				try {
					cx.close();
					if(ps!=null){
						ps.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return 0;		
	}

}
