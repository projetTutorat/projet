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
	
	
	// On récupère les id des éléments qui composent l'interface FXML
	@FXML private TextField textId; 
	@FXML private PasswordField textMdp; 
	@FXML private Label message; 
	@FXML private Button buttonCo; 
	
	//Méthode Login déclenchée à l'appuie du bouton Connexion
    public void Login(ActionEvent actionEvent) throws ClassNotFoundException, SQLException, IOException {
    	
    	
    	// Appel de la méthode connect() avec les valeurs des éléments qui composent l'interface FXML
    	PersonneDAO p = new PersonneDAO();
    	p.connect(textId, textMdp, message, buttonCo);
    	
    }
}
