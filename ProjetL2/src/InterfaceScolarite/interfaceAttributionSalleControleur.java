package InterfaceScolarite;
import Controleur.ControleurSalle;
import Controleur.ControleurSeance;
import DAO.EnseignantDAO;
import DAO.MatiereDAO;
import DAO.SalleDAO;
import DAO.SeanceDAO;
import Modele.Enseignant;
import Modele.Matiere;
import Modele.Salle;
import Modele.Seance;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TreeItem;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class interfaceAttributionSalleControleur implements Initializable {

    @FXML private ComboBox ComboBoxAttributionSalle;
    @FXML private Button Valider;


    /**
     * La méthode initialize n'est pas static et elle ne retourne rien.
     * Elle permet au lancement de l'interface de remplir les treeView
     *
     * @param actionEvent
     *          actionEvent
     * @throws IOException
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Seance seance= interfaceScolariteControleur.Instance.getSeance();
        if (seance.getBesoin().equals("salle info")){
            ControleurSalle.ajouterSalleInfoFormulaire(ComboBoxAttributionSalle);
        }
        else if (seance.getBesoin().equals("salle tp")){
            ControleurSalle.ajouterSalleTPFormulaire(ComboBoxAttributionSalle);
        }
        else{
            ControleurSalle.ajouterSalleNormaleFormulaire(ComboBoxAttributionSalle);
        }
    }
    /**
     * La méthode initialize n'est pas static et elle ne retourne rien.
     * Elle permet de confirmer la validation d'attribution d'une salle � une seance
     *
     * @param actionEvent
     *          actionEvent
     * @throws IOException
     */
    public void Valider(ActionEvent actionEvent) throws IOException {
        ControleurSeance.ajouterSalleASeance(ComboBoxAttributionSalle,interfaceScolariteControleur.Instance.getSeance(),Valider);
        interfaceScolariteControleur.Instance.reload();
    }
}
