package fr.adaming.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.adaming.model.User;

public class UserDaoImpl implements IUserDao{

		public static final String url="jdbc:mysql://localhost:3306/dbuser";
		public static final String userDb="root";
		public static final String passwordDb="root";
		
		private Connection cx=null;
		private PreparedStatement ps=null;
		
		@Override
		public void ajouterUserDao(User us){
			
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
				String sqlReq="INSERT INTO user (nom,prenom,mail,mdp) VALUES(?,?,?,?)";
				
				/**
				 * Creer un ps
				 */
				ps=cx.prepareStatement(sqlReq);
				
				/**
				 * Passer les valeurs des paramètres de la requete
				 */
				ps.setString(1, us.getNom());
				ps.setString(2, us.getPrenom());
				ps.setString(3, us.getMail());
				ps.setString(4, us.getPassword());
				
				/**
				 * Envoyer la requete et récupérer le résultat
				 */
				ps.executeUpdate();
		
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
		}

		@Override
		public List<User> getAllUserDao() {

			
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
				String sqlReq="SELECT * from user";
				
				/**
				 * Creer un ps
				 */
				ps=cx.prepareStatement(sqlReq);
				
				ResultSet rs=ps.executeQuery();
				
				/**
				 * Création d'une liste pour y mettre les utilisateurs
				 */
				
				List<User> listeUsers=new ArrayList<User>();
				
				
				while(rs.next()){
					User u=new User();
					u.setId(rs.getInt("id"));
					u.setNom(rs.getString("nom"));
					u.setPrenom(rs.getString("prenom"));
					u.setMail(rs.getString("mail"));
					u.setPassword(rs.getString("mdp"));
					listeUsers.add(u);					
				}
				return listeUsers;
			} catch (ClassNotFoundException e) {
				System.out.println("Exception ClassNotFound");
				e.printStackTrace();
			} catch (SQLException e) {
				System.out.println("Exception SQL");
				e.printStackTrace();
			}finally{
				try{
					if(cx!=null)
					{
					cx.close();
					}
					}catch(Exception e)
					{
					e.printStackTrace();	
					}
				}

			
			
			return null;
		}

		@Override
		public User getUserByIdDao(int id_user) {
			
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
				String sqlReq="SELECT * from user where id=?";
				
				/**
				 * Creer un ps
				 */
				ps=cx.prepareStatement(sqlReq);
				
				ps.setInt(1, id_user);
				
				ResultSet rs=ps.executeQuery();
				//"Genre" de curseur placé avant le tableau de résultat, on lui dit d'aller à la 1ère ligne du tablea
				rs.next();
				int id=rs.getInt("id");
				
				String nom=rs.getString("nom");
				String prenom=rs.getString("prenom");
				String mail=rs.getString("mail");
				String password=rs.getString("mdp");
				User us = new User(id, nom, prenom, mail, password); //User(id, nom, prenom, mail, rs.getString("mdp"));			
				return us;
						
			} catch (ClassNotFoundException e) {
				System.out.println("Exception ClassNotFound");
				e.printStackTrace();
			} catch (SQLException e) {
				System.out.println("Exception SQL");
				e.printStackTrace();
			}finally{
				try{
					if(cx!=null)
					{
					cx.close();
					}
					}catch(Exception e)
					{
					e.printStackTrace();	
					}
				}

			
			
			return null;
		}

		@Override
		public void supprimerUserDao(User us) {
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				
				cx=DriverManager.getConnection(url, userDb, passwordDb);
				
				String reqSql="DELETE from user where id=?";
				
				ps=cx.prepareStatement(reqSql);
				
				ps.setInt(1,us.getId());
				
				ps.executeUpdate();
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try{
					if(cx!=null)
					{
					cx.close();
					}
					}catch(Exception e)
					{
					e.printStackTrace();	
					}
				}
		}


		@Override
		public void modifierUserDao(User us) {
			
			try {
				
				Class.forName("com.mysql.jdbc.Driver");
				
				cx=DriverManager.getConnection(url, userDb, passwordDb);
				
				String reqSql="UPDATE user set nom=?, prenom=?, mail=?, mdp=? where id=?;";
				
				ps=cx.prepareStatement(reqSql);
				
				ps.setString(1, us.getNom());
				ps.setString(2, us.getPrenom());
				ps.setString(3, us.getMail());
				ps.setString(4, us.getPassword());
				ps.setInt(5, us.getId());
				
				ps.executeUpdate();				
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try{
					if(cx!=null)
					{
					cx.close();
					}
					}catch(Exception e)
					{
					e.printStackTrace();	
					}
				}
			
		}

	}
