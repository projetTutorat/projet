package InterfaceEnseignant;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Controleur.ControleurSeance;
import DAO.SeanceDAO;
import InterfaceConnexion.interfaceConnexionControleur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Class controlleur de l'interfaceCreerSeance
 */
public class interfaceCreerSeanceControleur implements Initializable {
	
	@FXML private Button buttonCreerSeance;
	@FXML private Button Retour;
	
	@FXML private DatePicker datePickerSeance;
	@FXML private TextField textNbEtuMax;
	@FXML private TextField textHeure;
	@FXML private Label erreur;
	@FXML private ComboBox listMat;
	@FXML private RadioButton rbInfo;
	@FXML private RadioButton rbTp;


	/**
	 * La méthode createSeance n'est pas static et elle ne retourne rien.
	 * Elle permet de créer une séance.
	 *
	 * @param actionEvent
	 * 			actionEvent
	 * @throws SQLException
	 */
	public void createSeance(ActionEvent actionEvent) {
			ControleurSeance.creerSeance(interfaceConnexionControleur.Instance.getNum(), datePickerSeance, listMat, textNbEtuMax, textHeure, erreur, rbInfo, rbTp, buttonCreerSeance);
		
    }

	/**
	 * La méthode Retour n'est pas static et elle ne retourne rien.
	 * Elle permet de fermer l'interface.
	 * @param actionEvent
	 * 			actionEvent
	 */
	public void Retour(ActionEvent actionEvent) {

		Stage interfaceCS = (Stage) Retour.getScene().getWindow();
        interfaceCS.close();

    }


	/**
	 * La méthode initialize n'est pas static et elle ne retourne rien.
	 * Elle permet de lancer la méthode qui permet d'ajouter les matières au formulaire.
	 *
	 * @param location
	 * 			L'url
	 * @param resources
	 * 			Les ressources
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			ControleurSeance.ajouterMatFormulaire(interfaceConnexionControleur.Instance.getNum(),listMat);
		} catch (SQLException e) {
			e.printStackTrace();
		}


	}

	

}
