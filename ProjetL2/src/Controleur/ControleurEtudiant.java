package Controleur;


import DAO.*;
import Modele.*;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ControleurEtudiant  {

	/**
     * La méthode afficherEtudiantAppel est static et ne retourne rien.
     * Elle permet d'afficher les etudiants disponibles dans un treeView en fonction d'une seance.
     *
     * @param seance   Le textField pour rentrer l'Id de l'utilisateur
     * @param treeView  Le textField pour rentrer le mot de passe de l'utilisateur
     */
    public static void afficherEtudiantAppel(Seance seance, TreeView treeView) {

        TreeItem afficherEtudiantAppel = new TreeItem("Seance Inscrits");

        treeView.setRoot(afficherEtudiantAppel);
        treeView.setShowRoot(false);

        List<Etudiant> listeEtudiant = EtudiantDAO.getEtudiantsByIdSeance(seance.getIdSeance(), seance.getNum_ens());

        for (Etudiant etudiant : listeEtudiant) {
            TreeItem treeItemEtudiant = new TreeItem(etudiant.getNumero_identification() + " " + etudiant.getNom() + " " + etudiant.getPrenom());

            afficherEtudiantAppel.getChildren().add(treeItemEtudiant);

        }
    }

}
