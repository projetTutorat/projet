package InterfaceEnseignant;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Controleur.ControleurPersonne;
import Controleur.ControleurSeance;
import DAO.PersonneDAO;
import DAO.SeanceDAO;
import InterfaceConnexion.interfaceConnexionControleur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TreeView;
import javafx.stage.Stage;
/**
 * class du controlleur de l'interface enseignant.
 */
public class interfaceEnseignantControleur implements Initializable   {
	
	@FXML private Button SeDeconnecter;

	@FXML private TreeView<String > TreeViewSeance;
	
    /**
     * La méthode Deconnect n'est pas static et elle ne retourne rien.
     * Elle permet de lancer la méthode SeDeconnecter ce qui déconnecte l'utilisateur et le renvois a l'interface Connexion.
     *
     * @param actionEvent
     *          actionEvent
     * @throws IOException
     */
	
	public void Deconnect(ActionEvent actionEvent) throws  IOException {


		ControleurPersonne.deconnect(SeDeconnecter);
    }
	
    /**
     * La méthode CreerUneSeance n'est pas static et elle ne retourne rien.
     * Elle permet de lancer l'interface CreerSeance
     *
     * @param actionEvent
     *          actionEvent
     * @throws IOException
     */
    public void CreerUneSeance(ActionEvent actionEvent) throws  IOException {
    	
       Stage interfaceCS = new Stage();
       new interfaceCreerSeance().start(interfaceCS);

        
    	
    }

    public void getListMesSeances(ActionEvent actionEvent) {
    	ControleurSeance.afficherMesTutoratsEnseignant(interfaceConnexionControleur.Instance.getNum(),TreeViewSeance);
        System.out.println(interfaceConnexionControleur.Instance.getNum());


    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ControleurSeance.afficherMesTutoratsEnseignant(interfaceConnexionControleur.Instance.getNum(),TreeViewSeance);
        System.out.println(interfaceConnexionControleur.Instance);
    }
}
