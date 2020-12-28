package InterfaceEnseignant;

import java.io.IOException;
import java.sql.SQLException;

import Controleur.ControleurPersonne;
import DAO.PersonneDAO;
import DAO.SeanceDAO;
import InterfaceConnexion.interfaceConnexionControleur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class interfaceEnseignantControleur {
	
	@FXML private Button SeDeconnecter;
	
	
	public void Deconnect(ActionEvent actionEvent) throws  IOException {


		ControleurPersonne.deconnect(SeDeconnecter);
    }
	
    public void CreerUneSeance(ActionEvent actionEvent) throws ClassNotFoundException, SQLException, IOException {
    	
    	
    	
    }
    
    public void getListMesSéances(ActionEvent actionEvent) throws ClassNotFoundException, SQLException, IOException {
    	
 
    	
    }


    public void getListMesSeances(ActionEvent actionEvent) throws ClassNotFoundException, SQLException, IOException {

        SeanceDAO s = new SeanceDAO();
        s.afficheMesTutoratsEnseignant(interfaceConnexionControleur.Instance.getNum());

    }

}
