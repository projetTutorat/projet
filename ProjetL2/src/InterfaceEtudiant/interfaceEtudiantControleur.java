package InterfaceEtudiant;

import java.io.IOException;
import java.sql.SQLException;

import Controleur.ControleurPersonne;
import DAO.PersonneDAO;
import DAO.SeanceDAO;
import InterfaceConnexion.interfaceConnexionControleur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class interfaceEtudiantControleur {
	
	@FXML private Button SeDeconnecter;
	
	
	public void Deconnect(ActionEvent actionEvent) throws ClassNotFoundException, SQLException, IOException {


		ControleurPersonne.deconnect(SeDeconnecter);
    }
    
    public void VoirLesTutoratsDisponibles(ActionEvent actionEvent) throws ClassNotFoundException, SQLException, IOException {
    	
    	SeanceDAO s = new SeanceDAO();
    	s.afficherSeanceDisponible(interfaceConnexionControleur.Instance.getNum());

    }
    
    
    public void getListMesTutorats(ActionEvent actionEvent) throws ClassNotFoundException, SQLException, IOException {
    	
    	SeanceDAO s = new SeanceDAO();
    	s.afficheSeanceInscrit(interfaceConnexionControleur.Instance.getNum());
    	
    }
    

}
