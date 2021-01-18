package InterfaceScolarite;
import Controleur.ControleurSalle;
import DAO.EnseignantDAO;
import DAO.MatiereDAO;
import DAO.SalleDAO;
import DAO.SeanceDAO;
import Modele.Enseignant;
import Modele.Matiere;
import Modele.Salle;
import Modele.Seance;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TreeItem;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class interfaceAttributionSalleControleur implements Initializable {

    @FXML private ComboBox ComboBoxAttributionSalle;


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
}
