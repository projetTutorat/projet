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
		
		//Connexion � la BDD
    	String url = "jdbc:mysql://localhost/projet?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String login = "root";
        String password = "";
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, login, password);

        //Cr�ation de statement pour ex�cuter les requ�tes SQL
        Statement stmt = con.createStatement();
        Statement stmt2 = con.createStatement();
        Statement stmt3 =con.createStatement();

        //Ecriture des requ�tes SQL et ex�cution
        String sql = "SELECT mdp FROM etudiant WHERE num_etu ='"+textId.getText()+"'";
        ResultSet rs = stmt.executeQuery(sql);
        
        String sql2 = "SELECT mdp FROM enseignant WHERE num_ens ='"+textId.getText()+"'";
        ResultSet rs2 = stmt2.executeQuery(sql2);

        String sql3 = "SELECT * FROM est_tuteur_etudiant WHERE num_etu='"+textId.getText()+"'";
        ResultSet rs3 = stmt3.executeQuery(sql3);




     // On v�rifie si le num�ro identifiant contenu dans le TextField correspond � un num�ro �tudiant de la table �tudiant
       if (rs.next()) {
    	   // On v�rifie si le mot de passe contenu dans le PasswordField correspond au num�ro �tudiant associ�
       if (textMdp.getText().equals(rs.getString(1))) {
    	   //Connexion r�ussie : on ferme la fen�tre connexion
    	   Stage interfaceCo = (Stage) buttonCo.getScene().getWindow();
    	   interfaceCo.close();
    	   // On v�rifie si le num�ro �tudiant est existant dans la table est_tuteur_�tudiant
    	   if (rs3.next()){ 
    		 //On ouvre l'interface tuteur
    			   Stage interfaceTut = new Stage();
                   new interfaceTuteur().start(interfaceTut);   		   
           }else {
        	   //On ouvre l'interface �tudiant
        	   Stage interfaceEtu = new Stage();
        	   new interfaceEtudiant().start(interfaceEtu); 
           }
    	   
        }else {
        	// Le mot de passe ne correspond pas au mot de passe associ� au num�ro �tudiant
        	message.setText("Mot de passe incorrect");
        }
    // On v�rifie si le num�ro identifiant contenu dans le TextField correspond � un num�ro enseignant de la table enseignant
       }else if(rs2.next()) { 
    	// On v�rifie si le mot de passe contenu dans le PasswordField correspond au num�ro enseignant associ�
    	   if (textMdp.getText().equals(rs2.getString(1))) {
    		 //Connexion r�ussie : on ferme la fen�tre connexion
        	   Stage interfaceCo = (Stage) buttonCo.getScene().getWindow();
        	   interfaceCo.close();
        	 //On ouvre l'interface enseignant
        	   Stage interfaceEns = new Stage();
        	   new interfaceEnseignant().start(interfaceEns);
        	   
            }else {
            	// Le mot de passe ne correspond pas au mot de passe associ� au num�ro enseignant
            	message.setText("Mot de passe incorrect");
            }
       }else {
    	   // Le num�ro identifiant contenu dans le TextField n'existe dans aucune table (ni �tudiant, ni enseignant)
    	   message.setText("Identifiant inexistant");
       }


	}

}
