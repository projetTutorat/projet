package InterfaceTuteur;

import java.io.IOException;
import java.sql.SQLException;

import Controleur.ControleurPersonne;
import DAO.PersonneDAO;
import InterfaceEtudiant.interfaceEtudiant;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class interfaceTuteurControleur {
	
	@FXML private Button SeDeconnecter;
	
	
	public void Deconnect(ActionEvent actionEvent) throws ClassNotFoundException, SQLException, IOException {


		ControleurPersonne.deconnect(SeDeconnecter);
    }
	
	public void ModeEtudiant(ActionEvent actionEvent) throws ClassNotFoundException, SQLException, IOException {
		
        Stage interfaceI = (Stage) SeDeconnecter.getScene().getWindow();
        interfaceI.close();

		Stage interfaceEtu = new Stage();
        new interfaceEtudiant().start(interfaceEtu);
    }



}
