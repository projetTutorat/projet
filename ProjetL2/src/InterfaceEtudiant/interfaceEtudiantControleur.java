package InterfaceEtudiant;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import Controleur.ControleurPersonne;
import Controleur.ControleurSeance;
import DAO.*;
import InterfaceConnexion.interfaceConnexionControleur;
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
 * class controlleur de l'interface etudiant
 */
public class interfaceEtudiantControleur implements Initializable  {


	@FXML private Button SeDeconnecter;
	@FXML private TreeView<String> TreeViewTutoratsDisponibles;
	@FXML private TreeView<String> TreeViewTutoratsInscrits;

	@FXML private AnchorPane Main;



	/**
	 * La méthode Deconnect n'est pas static et elle ne retourne rien.
	 * Elle permet de lancer la méthode SeDeconnecter
	 *
	 * @param actionEvent
	 * 			actionEvent
	 * @throws IOException
	 */
	public void Deconnect(ActionEvent actionEvent) throws  IOException {
		ControleurPersonne.deconnect(SeDeconnecter);
    }


	/**
	 * La méthode initialize n'est pas static et elle ne retourne rien.
	 * Elle permet au lancement de l'interface de remplir les treeView
	 *
	 * @param url
	 * 			L'url
	 * @param resourceBundle
	 * 			La ressourceBundle
	 */
	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		ControleurSeance.afficheSeanceInscrit(interfaceConnexionControleur.Instance.getNum(),TreeViewTutoratsInscrits);
		ControleurSeance.afficherSeanceDisponible(interfaceConnexionControleur.Instance.getNum(),TreeViewTutoratsDisponibles);
	}


	/**
	 *  La méthode inscriptionTutorat n'est pas static et elle ne retourne rien.
	 *  Elle permet lors du clic sur un tutorat disponible de faire apparaitre un garde fou, demandant une confirmation d'inscription a ce tutorat
	 * @param event
	 */
	public void inscriptionTutorat(MouseEvent event){

		Stage stage = (Stage) Main.getScene().getWindow();

		Alert.AlertType inscripton = Alert.AlertType.CONFIRMATION;

		Alert confirmation = new Alert(inscripton,"");
		confirmation.initModality(Modality.APPLICATION_MODAL);
		confirmation.initOwner(stage);

		confirmation.getDialogPane().setContentText("Etes-vous sur de vouloir vous inscrire a cette seance");
		confirmation.getDialogPane().setHeaderText("Incription Tutorat");

		Optional<ButtonType> result = confirmation.showAndWait();
			if (result.get()==ButtonType.OK){
				TreeItem<String> item =  TreeViewTutoratsDisponibles.getSelectionModel().getSelectedItem();
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






				SeanceDAO.ajouterEtudiantSeance(seance, interfaceConnexionControleur.Instance.getNum());
				SeanceDAO.decrementerPlaceSeance(seance);




				ControleurSeance.afficheSeanceInscrit(interfaceConnexionControleur.Instance.getNum(),TreeViewTutoratsInscrits);
				ControleurSeance.afficherSeanceDisponible(interfaceConnexionControleur.Instance.getNum(),TreeViewTutoratsDisponibles);




			}
			else if (result.get()== ButtonType.CANCEL){
			}

	}

	/**
	 *  La méthode desinscriptionTutorat n'est pas static et elle ne retourne rien.
	 *  Elle permet lors du clic sur un tutorat inscrit de faire apparaitre un garde fou, demandant une confirmation de desinscription de ce tutorat
	 * @param event
	 */

	public void desinscriptionTutorat(MouseEvent event){

		Stage stage = (Stage) Main.getScene().getWindow();

		Alert.AlertType inscripton = Alert.AlertType.CONFIRMATION;

		Alert confirmation = new Alert(inscripton,"");
		confirmation.initModality(Modality.APPLICATION_MODAL);
		confirmation.initOwner(stage);

		confirmation.getDialogPane().setContentText("Etes-vous sur de vouloir vous desinscrire a cette seance");
		confirmation.getDialogPane().setHeaderText("Demission Tutorat");

		Optional<ButtonType> result = confirmation.showAndWait();
		if (result.get()==ButtonType.OK){
			TreeItem<String> item =  TreeViewTutoratsInscrits.getSelectionModel().getSelectedItem();
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


			SeanceDAO.demissionEtudiantSeance(seance, interfaceConnexionControleur.Instance.getNum());
			SeanceDAO.incrementerPlaceSeance(seance);
			ControleurSeance.afficheSeanceInscrit(interfaceConnexionControleur.Instance.getNum(),TreeViewTutoratsInscrits);
			ControleurSeance.afficherSeanceDisponible(interfaceConnexionControleur.Instance.getNum(),TreeViewTutoratsDisponibles);





		}
		else if (result.get()== ButtonType.CANCEL){
		}

	}
}
