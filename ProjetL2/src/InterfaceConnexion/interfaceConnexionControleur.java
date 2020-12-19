package InterfaceConnexion;

import java.io.IOException;
import java.sql.SQLException;


import DAO.PersonneDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class interfaceConnexionControleur{
	
	
	// On r�cup�re les id des �l�ments qui composent l'interface FXML
	@FXML private TextField textId; 
	@FXML private PasswordField textMdp; 
	@FXML private Label message; 
	@FXML private Button buttonCo; 
	
	//M�thode Login d�clench�e � l'appuie du bouton Connexion
    public void Login(ActionEvent actionEvent) throws ClassNotFoundException, SQLException, IOException {
    	
    	
    	// Appel de la m�thode connect() avec les valeurs des �l�ments qui composent l'interface FXML
    	PersonneDAO p = new PersonneDAO();
    	p.connect(textId, textMdp, message, buttonCo);
    	
    }
}
