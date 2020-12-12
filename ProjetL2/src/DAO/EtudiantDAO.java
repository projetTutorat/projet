package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import InterfaceEtudiant.interfaceEtudiant;
import javafx.scene.control.TextField;


public class EtudiantDAO {
	
	
	public void connect_etu(TextField textId, TextField textMdp) throws ClassNotFoundException, SQLException {
		
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
    	   System.out.println("Connexion réussie");
    	   interfaceEtudiant.launch();
        }else {
        	System.out.println("Mot de passe incorrect");
        }
       }else {
    	   System.out.println("Identifiant inexistant");
       }


	}
}
