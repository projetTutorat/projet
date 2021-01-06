package Controleur;

import DAO.ConnexionBDD;
import DAO.EnseignantDAO;
import DAO.EtudiantDAO;
import DAO.TuteurDAO;
import InterfaceConnexion.interfaceConnexion;
import InterfaceEnseignant.interfaceEnseignant;
import InterfaceEtudiant.interfaceEtudiant;
import InterfaceTuteur.interfaceTuteur;
import Modele.Enseignant;
import Modele.Etudiant;
import Modele.Tuteur;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Classe controleur personne
 */
public class ControleurPersonne {

    /**
     * La méthode connect est static et ne retourne rien.
     * Elle permet de se connecter à l'application à partir d'un Id et d'un mot de passe.
     *
     * @param textId
     *          Le textField pour rentrer l'Id de l'utilisateur
     * @param textMdp
     *          Le textField pour rentrer le mot de passe de l'utilisateur
     * @param message
     *          Renvois un message d'erreur si le formualire est mal remplit
     * @param buttonCo
     *          Le Button pour lancer la connection à partir du formulaire remplit
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws SQLException Si les éléments ne sont pas trouvés dans la base
     */
    public static void connect(TextField textId, TextField textMdp, Label message, Button buttonCo) throws IOException, ClassNotFoundException, SQLException {


        Etudiant etudiant = EtudiantDAO.getEtudiantById(textId.getText());
        Enseignant enseignant = EnseignantDAO.getEnseignantById(textId.getText());
        Tuteur tuteur = TuteurDAO.etudiantEstTuteur(textId.getText());


        // On vérifie si le numéro identifiant contenu dans le TextField correspond à un numéro étudiant de la table étudiant
        if (etudiant.getNumero_identification() != null) {
            // On vérifie si le mot de passe contenu dans le PasswordField correspond au numéro étudiant associé
            if (textMdp.getText().equals(etudiant.getMot_de_passe())) {
                //Connexion réussie : on ferme la fenêtre connexion
                Stage interfaceCo = (Stage) buttonCo.getScene().getWindow();
                interfaceCo.close();
                // On vérifie si le numéro étudiant est existant dans la table est_tuteur_étudiant
                if (tuteur.getNumero_identification()!=null) {
                    //On ouvre l'interface tuteur

                    Stage interfaceTut = new Stage();
                    new interfaceTuteur().start(interfaceTut);

                } else {
                    //On ouvre l'interface étudiant

                    Stage interfaceEtu = new Stage();
                    new interfaceEtudiant().start(interfaceEtu);
                }

            } else {
                // Le mot de passe ne correspond pas au mot de passe associé au numéro étudiant
                message.setText("Mot de passe incorrect");
            }
            // On vérifie si le numéro identifiant contenu dans le TextField correspond à un numéro enseignant de la table enseignant
        } else if (enseignant.getNumero_identification() != null) {
            // On vérifie si le mot de passe contenu dans le PasswordField correspond au numéro enseignant associé
            if (textMdp.getText().equals(enseignant.getMot_de_passe())) {
                //Connexion réussie : on ferme la fenêtre connexion
                Stage interfaceCo = (Stage) buttonCo.getScene().getWindow();
                interfaceCo.close();
                //On ouvre l'interface enseignant
                Stage interfaceEns = new Stage();
                new interfaceEnseignant().start(interfaceEns);


            } else {
                // Le mot de passe ne correspond pas au mot de passe associé au numéro enseignant
                message.setText("Mot de passe incorrect");
            }
        } else {
            // Le numéro identifiant contenu dans le TextField n'existe dans aucune table (ni étudiant, ni enseignant)
            message.setText("Identifiant inexistant");
        }


    }


    /**
     * La méthode deconnect est static et ne retourne rien.
     * Elle permet de déconnecter un utilisateur de l'application et le renvoyer a l'interface connexion.
     *
     * @param SeDeconnecter
     *          Le Button se deconnecter pour lancer la déconnexion
     * @throws IOException
     */
    
    public static void deconnect(Button SeDeconnecter) throws IOException {
        //Fermeture interface actuelle
        Stage interfaceI = (Stage) SeDeconnecter.getScene().getWindow();
        interfaceI.close();

        //Ouverture interface de connexion
        Stage interfaceCo = new Stage();
        new interfaceConnexion().start(interfaceCo);
    }
}
