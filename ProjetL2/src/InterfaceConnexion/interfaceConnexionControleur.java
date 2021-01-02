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
	
	// On récupère les id des éléments qui composent l'interface FXML
	@FXML private TextField textId; 
	@FXML private PasswordField textMdp; 
	@FXML private Label message; 
	@FXML private Button buttonCo;

	
	//Méthode Login déclenchée à l'appuie du bouton Connexion
    public void Login(ActionEvent actionEvent) throws ClassNotFoundException, SQLException, IOException {
    	
    	
    	// Appel de la méthode connect() avec les valeurs des éléments qui composent l'interface FXML
		ControleurPersonne.connect(textId, textMdp, message, buttonCo);

    	
    	//Récupération du numéro identifiant
    	num = textId.getText();
    	
   
    }
    
    public void ChangePswd(ActionEvent actionEvent) throws ClassNotFoundException, SQLException, IOException {
    	BrowserControl.displayURL("https://multipass.univ-tours.fr/activation.php");
    }
    
	//Création String num avec son getter
	private String num;
	public String getNum() {
		return num;
	}
	
	// On crée une instance statique qui va nous permettre de récupérer les méthodes à travers d'autre classe sans faire de new
	public static interfaceConnexionControleur Instance;
	
	public interfaceConnexionControleur(){
		Instance = this;
	}



    
    
}
