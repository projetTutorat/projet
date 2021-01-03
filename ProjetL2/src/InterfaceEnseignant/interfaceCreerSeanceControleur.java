package InterfaceEnseignant;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

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

public class interfaceCreerSeanceControleur implements Initializable {
	
	@FXML private Button buttonCreerSeance;
	@FXML private Button Retour;
	
	@FXML private DatePicker datePickerSeance;
	@FXML private TextField textNbEtuMax;
	@FXML private TextField textBesoin;
	@FXML private TextField textHeure;
	@FXML private Label erreur;
	@FXML private ComboBox listMat;
	@FXML private RadioButton rbInfo;
	@FXML private RadioButton rbTp;
 
	
	public void createSeance(ActionEvent actionEvent) throws  IOException, SQLException {

        SeanceDAO s = new SeanceDAO();
        s.creerSeance(interfaceConnexionControleur.Instance.getNum(), datePickerSeance, listMat, textNbEtuMax, textBesoin, textHeure, erreur, rbInfo, rbTp, buttonCreerSeance);
		
    }
	
	public void Retour(ActionEvent actionEvent) throws  IOException {

		Stage interfaceCS = (Stage) Retour.getScene().getWindow();
        interfaceCS.close();

    }
	



	@Override
	public void initialize(URL location, ResourceBundle resources) {

		SeanceDAO s = new SeanceDAO();
		try {
			s.ajouterMatFormulaire(interfaceConnexionControleur.Instance.getNum(),listMat);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	

}
