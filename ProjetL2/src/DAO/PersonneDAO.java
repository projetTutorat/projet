package DAO;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

import InterfaceEnseignant.interfaceEnseignant;
import InterfaceEtudiant.interfaceEtudiant;
import InterfaceTuteur.interfaceTuteur;

public class PersonneDAO {
 
	public void connect(TextField textId, TextField textMdp, Label message, Button buttonCo) throws ClassNotFoundException, SQLException, IOException {
		
		//Connexion à la BDD
    	String url = "jdbc:mysql://localhost/projet?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String login = "root";
        String password = "";
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, login, password);

        //Création de statement pour exécuter les requêtes SQL
        Statement stmt = con.createStatement();
        Statement stmt2 = con.createStatement();
        Statement stmt3 =con.createStatement();

        //Ecriture des requêtes SQL et exécution
        String sql = "SELECT mdp FROM etudiant WHERE num_etu ='"+textId.getText()+"'";
        ResultSet rs = stmt.executeQuery(sql);
        
        String sql2 = "SELECT mdp FROM enseignant WHERE num_ens ='"+textId.getText()+"'";
        ResultSet rs2 = stmt2.executeQuery(sql2);

        String sql3 = "SELECT * FROM est_tuteur_etudiant WHERE num_etu='"+textId.getText()+"'";
        ResultSet rs3 = stmt3.executeQuery(sql3);




     // On vérifie si le numéro identifiant contenu dans le TextField correspond à un numéro étudiant de la table étudiant
       if (rs.next()) {
    	   // On vérifie si le mot de passe contenu dans le PasswordField correspond au numéro étudiant associé
       if (textMdp.getText().equals(rs.getString(1))) {
    	   //Connexion réussie : on ferme la fenêtre connexion
    	   Stage interfaceCo = (Stage) buttonCo.getScene().getWindow();
    	   interfaceCo.close();
    	   // On vérifie si le numéro étudiant est existant dans la table est_tuteur_étudiant
    	   if (rs3.next()){ 
    		 //On ouvre l'interface tuteur
    			   Stage interfaceTut = new Stage();
                   new interfaceTuteur().start(interfaceTut);   		   
           }else {
        	   //On ouvre l'interface étudiant
        	   Stage interfaceEtu = new Stage();
        	   new interfaceEtudiant().start(interfaceEtu); 
           }
    	   
        }else {
        	// Le mot de passe ne correspond pas au mot de passe associé au numéro étudiant
        	message.setText("Mot de passe incorrect");
        }
    // On vérifie si le numéro identifiant contenu dans le TextField correspond à un numéro enseignant de la table enseignant
       }else if(rs2.next()) { 
    	// On vérifie si le mot de passe contenu dans le PasswordField correspond au numéro enseignant associé
    	   if (textMdp.getText().equals(rs2.getString(1))) {
    		 //Connexion réussie : on ferme la fenêtre connexion
        	   Stage interfaceCo = (Stage) buttonCo.getScene().getWindow();
        	   interfaceCo.close();
        	 //On ouvre l'interface enseignant
        	   Stage interfaceEns = new Stage();
        	   new interfaceEnseignant().start(interfaceEns);
        	   
            }else {
            	// Le mot de passe ne correspond pas au mot de passe associé au numéro enseignant
            	message.setText("Mot de passe incorrect");
            }
       }else {
    	   // Le numéro identifiant contenu dans le TextField n'existe dans aucune table (ni étudiant, ni enseignant)
    	   message.setText("Identifiant inexistant");
       }


	}

}
