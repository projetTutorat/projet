package InterfaceConnexion;

import java.io.IOException;
import java.sql.SQLException;
import DAO.EtudiantDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class interfaceConnexionControleur{
	
	@FXML private TextField textId; 
	@FXML private PasswordField textMdp; 
	@FXML private Label message; 
	@FXML private Button buttonCo; 
	
    public void Login(ActionEvent actionEvent) throws ClassNotFoundException, SQLException, IOException {
    	
    
    	EtudiantDAO etu = new EtudiantDAO();
    	etu.connect_etu(textId,textMdp,message,buttonCo);;
    	
    }
}
