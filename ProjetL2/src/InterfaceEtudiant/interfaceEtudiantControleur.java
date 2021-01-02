package InterfaceEtudiant;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

import Controleur.ControleurPersonne;
import Controleur.ControleurSeance;
import DAO.EtudiantDAO;
import DAO.PersonneDAO;
import DAO.SeanceDAO;
import InterfaceConnexion.interfaceConnexionControleur;
import Modele.Etudiant;
import Modele.Seance;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class interfaceEtudiantControleur implements Initializable  {


	@FXML private Button SeDeconnecter;
	@FXML private TreeView<String> TreeViewTutoratsDisponibles;
	@FXML private TreeView TreeViewTutoratsInscrits;

	@FXML private AnchorPane Main;

	@FXML public static Label test;




	public void Deconnect(ActionEvent actionEvent) throws ClassNotFoundException, SQLException, IOException {


		ControleurPersonne.deconnect(SeDeconnecter);
    }
    
    public void VoirLesTutoratsDisponibles(ActionEvent actionEvent) throws ClassNotFoundException, SQLException, IOException {

		ControleurSeance.afficherSeanceDisponible(interfaceConnexionControleur.Instance.getNum(),TreeViewTutoratsDisponibles);


    }
    
    
    public void getListMesTutorats(ActionEvent actionEvent) throws ClassNotFoundException, SQLException, IOException {
    	ControleurSeance.afficheSeanceInscrit(interfaceConnexionControleur.Instance.getNum(),TreeViewTutoratsInscrits);
    }
    /*

    public  static void afficherNomPrenom(){
		Etudiant etudiant = EtudiantDAO.getEtudiantById(interfaceConnexionControleur.Instance.getNum());
		System.out.println(etudiant.toString());
		SimpleStringProperty text = new SimpleStringProperty("Bonjour, ");
		SimpleStringProperty prenom = new SimpleStringProperty(etudiant.getPrenom());
		SimpleStringProperty nom = new SimpleStringProperty(etudiant.getNom());
		Bonjour.setText(String.valueOf(prenom));



	}


     */

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		ControleurSeance.afficheSeanceInscrit(interfaceConnexionControleur.Instance.getNum(),TreeViewTutoratsInscrits);
		ControleurSeance.afficherSeanceDisponible(interfaceConnexionControleur.Instance.getNum(),TreeViewTutoratsDisponibles);
	}




	public void selectItem(MouseEvent event){

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
				System.out.println(item);
				String date= String.valueOf(item).substring(29,39);
				String horaire=String.valueOf(item).substring(43,51);
				String besoin=(String.valueOf(item).split("   Besoin: ")[1]);
				String besoin2=(besoin.split("   Salle: ")[0]).substring(0,besoin.split("   Salle: ")[0].length()-1);
				String salle=((String.valueOf(item)).split("   Salle: ")[1]);
				String salle2=(salle.split("   Matiere: ")[0]).substring(0,salle.split("   Matiere: ")[0].length()-1);
				String matiere= (String.valueOf(item).split("   Matiere: ")[1]);
				String matiere2= (matiere.split("   Professeur: ")[0]).substring(0,matiere.split("   Professeur: ")[0].length()-1);
				String enseignant=(String.valueOf(item).split("   Professeur: ")[1]).substring(0,(String.valueOf(item).split("   Professeur: ")[1]).length()-2);
				System.out.println(date);
				System.out.println(horaire);
				System.out.println(besoin2);
				System.out.println(salle2);
				System.out.println(matiere2);
				System.out.println(enseignant);
			}
			else if (result.get()== ButtonType.CANCEL){
			}

	}

}
