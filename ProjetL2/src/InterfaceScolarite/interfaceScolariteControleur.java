package InterfaceScolarite;

import Controleur.ControleurPersonne;
import Controleur.ControleurSeance;
import DAO.EnseignantDAO;
import DAO.MatiereDAO;
import DAO.SalleDAO;
import DAO.SeanceDAO;
import InterfaceConnexion.interfaceConnexionControleur;
import Modele.Enseignant;
import Modele.Matiere;
import Modele.Salle;
import Modele.Seance;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class interfaceScolariteControleur implements Initializable {

    @FXML private AnchorPane Main;
    @FXML private Button SeDeconnecter;
    @FXML private TreeView<String> TreeViewTutoratsSansSalle;



    public void Deconnect(ActionEvent actionEvent) throws IOException {

        ControleurPersonne.deconnect(SeDeconnecter);
    }



    public void attributionSalle(MouseEvent event) throws IOException {

        Stage stage = (Stage) Main.getScene().getWindow();

        Alert.AlertType inscripton = Alert.AlertType.CONFIRMATION;

        Alert confirmation = new Alert(inscripton,"");
        confirmation.initModality(Modality.APPLICATION_MODAL);
        confirmation.initOwner(stage);

        confirmation.getDialogPane().setContentText("Voulez-vous attribuer une salle a cette séance");
        confirmation.getDialogPane().setHeaderText("Attribution salle");

        Optional<ButtonType> result = confirmation.showAndWait();
        if (result.get()==ButtonType.OK){
            Stage interfaceSalle = new Stage();
            new interfaceAttributionSalle().start(interfaceSalle);







        }
        else if (result.get()== ButtonType.CANCEL){
        }

    }

    public Seance getSeance() {
        TreeItem<String> item =  TreeViewTutoratsSansSalle.getSelectionModel().getSelectedItem();
        String date= String.valueOf(item).substring(29,39);
        String horaire=String.valueOf(item).substring(43,51);
        String besoin=(String.valueOf(item).split("   Besoin: ")[1]);
        String besoin2=(besoin.split("   Salle: ")[0]).substring(0,besoin.split("   Salle: ")[0].length()-1);
        String salle=((String.valueOf(item)).split("   Salle: ")[1]);
        String salle2=(salle.split("   Matiere: ")[0]).substring(0,salle.split("   Matiere: ")[0].length()-1);
        String matiere= (String.valueOf(item).split("   Matiere: ")[1]);
        String matiere2= (matiere.split("   Professeur: ")[0]).substring(0,matiere.split("   Professeur: ")[0].length()-1);
        String enseignant=(String.valueOf(item).split("   Professeur: ")[1]).substring(0,(String.valueOf(item).split("   Professeur: ")[1]).length()-2);

        Enseignant enseignant1= EnseignantDAO.getEnseignantByNomPrenom(enseignant.split(" ")[0],enseignant.split(" ")[1]);

        Matiere matiere3= MatiereDAO.getMatiereBySousCategorie("EP"+matiere2.split("EP")[1]);
        Salle salle3= SalleDAO.getSalleBySiteBatimentEtageNumeroSalle(salle2.split(" ")[0],(salle2.split(" ")[1]),(Integer.parseInt(salle2.split(" ")[2])),(salle2.split(" ")[3]));


        Seance seance= SeanceDAO.getSeanceByDateHoraireBesoinSalleMatiereNumEns(date,horaire,besoin2,salle3.getIdSalle(),enseignant1.getNumero_identification());
        return seance;
    }

    public static interfaceScolariteControleur Instance;

    public interfaceScolariteControleur(){
        Instance = this;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ControleurSeance.afficheSeanceSansSalle(TreeViewTutoratsSansSalle);
    }
}
