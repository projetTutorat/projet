package DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import InterfaceConnexion.interfaceConnexion;
import InterfaceEtudiant.interfaceEtudiant;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class EtudiantDAO {
	
	
	
	
	public void connect_etu(TextField textId, TextField textMdp, Label message, Button buttonCo) throws ClassNotFoundException, SQLException, IOException {
		
    	String url = "jdbc:mysql://localhost/projet";
        String login = "root";
        String password = "";
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, login, password);

        Statement stmt = con.createStatement();
        
        String sql = "SELECT mdp FROM etudiant WHERE num_etu ='"+textId.getText()+"'";
        ResultSet rs = stmt.executeQuery(sql);

       if (rs.next()) {
       if (textMdp.getText().equals(rs.getString(1))) {
    	   //fermer la fenêtre connexion
    	   Stage interfaceCo = (Stage) buttonCo.getScene().getWindow();
    	   interfaceCo.close();
    	   //ouvrir l'interface étudiant
    	   Stage interfaceEtu = new Stage();
    	   new interfaceEtudiant().start(interfaceEtu);
    	   
        }else {
        	message.setText("Mot de passe incorrect");
        }
       }else {
    	   message.setText("Numéro étudiant inexistant");
       }


	}
}
