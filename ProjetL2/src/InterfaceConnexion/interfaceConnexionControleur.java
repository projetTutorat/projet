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

/**
 * class controlleur de l'interface connexion
 */
public class interfaceConnexionControleur {

	// On récupère les id des éléments qui composent l'interface FXML
	@FXML private TextField textId;
	@FXML private PasswordField textMdp;
	@FXML private Label message;
	@FXML private Button buttonCo;

	/**
	 * La mÃ©thode Login n'est pas static et elle ne retourne rien.
	 * Elle permet de lancer la connexion lors de l'appuie du bouton Connexion sur l'interface connexion.
	 *
	 * @param actionEvent
	 * 			actionEvent dÃ©clanchÃ© par le bouton connexion
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws IOException
	 */

	//Méthode Login déclenchée à l'appuie du bouton Connexion
	
	public void Login(ActionEvent actionEvent) throws ClassNotFoundException, SQLException, IOException {


		// Appel de la méthode connect() avec les valeurs des éléments qui composent l'interface FXML
		ControleurPersonne.connect(textId, textMdp, message, buttonCo);


	}




	/**
	 * La mÃ©thode ChangePswd n'est pas static et elle ne retourne rien.
	 * Elle permet de changer le motdepasse en redirigeant l'utilisateur vers un lien.
	 *
	 * @param actionEvent
	 * 			actionEvent
	 */

	public void ChangePswd(ActionEvent actionEvent){
		BrowserControl.displayURL("https://multipass.univ-tours.fr/activation.php");
	}

	public String getNum() {
		return textId.getText();
	}

	// On crée une instance statique qui va nous permettre de récupérer les méthodes à travers d'autre classe sans faire de new
	public static interfaceConnexionControleur Instance;

	public interfaceConnexionControleur(){
		Instance = this;
	}


}
