package InterfaceTuteur;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

import Controleur.ControleurPersonne;
import Controleur.ControleurSeance;
import DAO.*;
import InterfaceConnexion.interfaceConnexionControleur;
import InterfaceEtudiant.interfaceEtudiant;
import Modele.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
/**
 * class controlleur de l'interface tuteur
 */
public class interfaceTuteurControleur implements Initializable  {


	@FXML private AnchorPane Main;
	@FXML private Button SeDeconnecter;
    @FXML private TreeView<String> treeViewTutoratsDisponiblesTuteur;
    @FXML private TreeView treeViewTutoratsInscritsTuteur;
    @FXML private Button Tutorat;


    /**
     * La méthode Deconnect n'est pas static et elle ne retourne rien.
     * ELle permet de lancer la méthode SeDeconnecter.
     *
     * @param actionEvent
     *          actionEvent
     * @throws IOException
     */
	public void Deconnect(ActionEvent actionEvent) throws IOException {


		ControleurPersonne.deconnect(SeDeconnecter);
    }


    /**
     * La méthode ModeEtudiant n'est pas static et elle ne retourne rien.
     * Elle permet de fermet l'interface et lancer l'interface Etudiant.
     *
     * @param actionEvent
     *          actionEvent
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws IOException
     */
	public void ModeEtudiant(ActionEvent actionEvent) throws ClassNotFoundException, SQLException, IOException {
		
        Stage interfaceI = (Stage) SeDeconnecter.getScene().getWindow();
        interfaceI.close();

		Stage interfaceEtu = new Stage();
        new interfaceEtudiant().start(interfaceEtu);
    }




    public void inscriptionTutoratTuteur(MouseEvent event){

        Stage stage = (Stage) Main.getScene().getWindow();

        Alert.AlertType inscripton = Alert.AlertType.CONFIRMATION;

        Alert confirmation = new Alert(inscripton,"");
        confirmation.initModality(Modality.APPLICATION_MODAL);
        confirmation.initOwner(stage);

        confirmation.getDialogPane().setContentText("Etes-vous sur de vouloir vous inscrire a cette seance");
        confirmation.getDialogPane().setHeaderText("Incription Tutorat");

        Optional<ButtonType> result = confirmation.showAndWait();
        if (result.get()==ButtonType.OK){
            TreeItem<String> item =  treeViewTutoratsDisponiblesTuteur.getSelectionModel().getSelectedItem();
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


            Tuteur tuteur = TuteurDAO.getTuteurById(interfaceConnexionControleur.Instance.getNum());
            System.out.println(tuteur.toString());



            SeanceDAO.ajouterTuteurSeance(seance, tuteur.getIdTuteur());




            ControleurSeance.afficheSeanceInscritTuteur(interfaceConnexionControleur.Instance.getNum(),treeViewTutoratsInscritsTuteur);
            ControleurSeance.afficherSeanceDisponibleTuteur(interfaceConnexionControleur.Instance.getNum(),treeViewTutoratsDisponiblesTuteur);




        }
        else if (result.get()== ButtonType.CANCEL){
        }

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ControleurSeance.afficheSeanceInscritTuteur(interfaceConnexionControleur.Instance.getNum(),treeViewTutoratsInscritsTuteur);
        ControleurSeance.afficherSeanceDisponibleTuteur(interfaceConnexionControleur.Instance.getNum(),treeViewTutoratsDisponiblesTuteur);

    }
}
