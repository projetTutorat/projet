package InterfaceEnseignant;

import java.io.IOException;
import java.sql.SQLException;

import Controleur.ControleurPersonne;
import Controleur.ControleurSeance;
import DAO.PersonneDAO;
import DAO.SeanceDAO;
import InterfaceConnexion.interfaceConnexionControleur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TreeView;
import javafx.stage.Stage;

public class interfaceEnseignantControleur {
	
	@FXML private Button SeDeconnecter;

	@FXML private TreeView treeViewAfficherSeance;
	
	
	public void Deconnect(ActionEvent actionEvent) throws  IOException {


		ControleurPersonne.deconnect(SeDeconnecter);
    }
	

    public void CreerUneSeance(ActionEvent actionEvent) throws ClassNotFoundException, SQLException, IOException {
    	
       Stage interfaceCS = new Stage();
       new interfaceCreerSeance().start(interfaceCS);

        
    	
    }
    
    public void getListMesSéances(ActionEvent actionEvent) throws ClassNotFoundException, SQLException, IOException {
    	
 
    	
    }


    public void getListMesSeances(ActionEvent actionEvent) throws ClassNotFoundException, SQLException, IOException {

        ControleurSeance.afficherMesTutoratsEnseignant(interfaceConnexionControleur.Instance.getNum(), treeViewAfficherSeance);

    }

}
