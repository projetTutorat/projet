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
		
    	String url = "jdbc:mysql://localhost/projet?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String login = "root";
        String password = "";
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, login, password);

        Statement stmt = con.createStatement();
        Statement stmt2 = con.createStatement();
        Statement stmt3 =con.createStatement();

        String sql = "SELECT mdp FROM etudiant WHERE num_etu ='"+textId.getText()+"'";
        ResultSet rs = stmt.executeQuery(sql);
        
        String sql2 = "SELECT mdp FROM enseignant WHERE num_ens ='"+textId.getText()+"'";
        ResultSet rs2 = stmt2.executeQuery(sql2);

        String sql3 = "SELECT * FROM est_tuteur_etudiant WHERE num_etu='"+textId.getText()+"'";
        ResultSet rs3 = stmt3.executeQuery(sql3);




        if (rs.next()) {
       if (textMdp.getText().equals(rs.getString(1))) {
    	   //fermer la fenêtre connexion
    	   Stage interfaceCo = (Stage) buttonCo.getScene().getWindow();
    	   interfaceCo.close();
    	   if (rs3.next()){
    		 //ouvrir l'interface tuteur
    			   Stage interfaceTut = new Stage();
                   new interfaceTuteur().start(interfaceTut);   		   
           }else {
        	   //ouvrir l'interface étudiant
        	   Stage interfaceEtu = new Stage();
        	   new interfaceEtudiant().start(interfaceEtu); 
           }
    	   
        }else {
        	message.setText("Mot de passe incorrect");
        }
       }else if(rs2.next()) {
    	   if (textMdp.getText().equals(rs2.getString(1))) {
        	   //fermer la fenêtre connexion
        	   Stage interfaceCo = (Stage) buttonCo.getScene().getWindow();
        	   interfaceCo.close();
        	   //ouvrir l'interface enseignant
        	   Stage interfaceEns = new Stage();
        	   new interfaceEnseignant().start(interfaceEns);
        	   
            }else {
            	message.setText("Mot de passe incorrect");
            }
       }else {
    	   message.setText("Identifiant inexistant");
       }


	}

}
