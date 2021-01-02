package InterfaceConnexion;

import java.io.IOException;
import java.sql.SQLException;

import Controleur.ControleurPersonne;
import DAO.EtudiantDAO;
import DAO.PersonneDAO;
import InterfaceEtudiant.interfaceEtudiantControleur;
import Modele.Personne;
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
		ControleurPersonne.connect(textId, textMdp, message, buttonCo);

    	
    	//R�cup�ration du num�ro identifiant
    	num = textId.getText();
    	
   
    }
    
    public void ChangePswd(ActionEvent actionEvent) throws ClassNotFoundException, SQLException, IOException {
    	BrowserControl.displayURL("https://multipass.univ-tours.fr/activation.php");
    }
    
	//Cr�ation String num avec son getter
	private String num;
	public String getNum() {
		return num;
	}
	
	// On cr�e une instance statique qui va nous permettre de r�cup�rer les m�thodes � travers d'autre classe sans faire de new
	public static interfaceConnexionControleur Instance;
	
	public interfaceConnexionControleur(){
		Instance = this;
	}



    
    
}
