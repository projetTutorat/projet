package InterfaceTuteur;

import Controleur.ControleurEtudiant;
import Controleur.ControleurSeance;
import DAO.*;
import InterfaceConnexion.interfaceConnexionControleur;
import InterfaceEtudiant.interfaceEtudiant;
import Modele.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.junit.FixMethodOrder;


import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

public class interfaceAppelControleur implements Initializable {

    @FXML private AnchorPane Main;
    @FXML private TreeView<String> TreeViewListeEtudiant;
    @FXML private Button valider;

    
    /**
     * La méthode etudiantPresent n'est pas static et elle ne retourne rien.
     * Elle permet mettre un etudiant present ou non
     */
    public void etudiantPresent(){
        Stage stage = (Stage) Main.getScene().getWindow();

        Alert.AlertType inscripton = Alert.AlertType.CONFIRMATION;

        Alert confirmation = new Alert(inscripton,"");
        confirmation.initModality(Modality.APPLICATION_MODAL);
        confirmation.initOwner(stage);

        confirmation.getDialogPane().setContentText("Cet etudiant n'est pas présent à la séance de tutorat");
        confirmation.getDialogPane().setHeaderText("Appel ");

        Optional<ButtonType> result = confirmation.showAndWait();
        if (result.get()==ButtonType.OK){
            TreeItem<String> item =  TreeViewListeEtudiant.getSelectionModel().getSelectedItem();
            String num_etu=  (item.getValue()).split(" ")[0];
            Etudiant etudiant = EtudiantDAO.getEtudiantById(num_etu);
            EtudiantDAO.modifierAbsenceEtudiant(etudiant);



        }
        else if (result.get()== ButtonType.CANCEL){
        }

    }

    
    /**
     * La méthode fermer n'est pas static et elle ne retourne rien.
     * Elle permet de fermer une interface
     *
     * @param actionEvent
     *          actionEvent
     */
    public void fermer(ActionEvent actionEvent) {

        Stage interfaceCS = (Stage) valider.getScene().getWindow();
        interfaceCS.close();
    }



    /**
     * La méthode initialize n'est pas static et elle ne retourne rien.
     * Elle permet au lancement de l'interface de remplir les treeView
     *
     * @param actionEvent
     *          actionEvent
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ControleurEtudiant.afficherEtudiantAppel(interfaceTuteurControleur.Instance.getSeance(),TreeViewListeEtudiant);
    }
}
