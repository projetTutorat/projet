package InterfaceConnexion;

import java.sql.SQLException;
import DAO.EtudiantDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class interfaceConnexionControleur{
	
	@FXML private TextField textId; 
	@FXML private PasswordField textMdp; 
	
    public void Login(ActionEvent actionEvent) throws ClassNotFoundException, SQLException {
    	
    	try {
    	EtudiantDAO etu = new EtudiantDAO();
    	etu.connect_etu(textId,textMdp);;
    	}catch (Exception e) {
    		System.out.println("Erreur: mettre mysql connector");
    	}
    	
    	
        
    }
}
