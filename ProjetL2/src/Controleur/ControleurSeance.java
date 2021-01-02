package Controleur;

import DAO.*;
import Modele.*;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ControleurSeance {


    public static void afficherSeanceDisponible(String num_etu, TreeView treeView)  {

        List<Seance> listeSeance = SeanceDAO.getSeancesByNumEtu(num_etu);

        TreeItem afficherSeanceDisponible =new  TreeItem("Seance Disponibles");

        treeView.setRoot(afficherSeanceDisponible);
        treeView.setShowRoot(false);


        Seance seance1= SeanceDAO.getIdSeanceByNumEtu(num_etu);



        for(Seance seance :listeSeance) {
            Matiere matiere = MatiereDAO.getMatiereById(seance.getIdMat());

            Salle salle = SalleDAO.getSalleById(seance.getIdSalle());

            Enseignant enseignant = EnseignantDAO.getEnseignantById(seance.getNum_ens());

            if ((seance.getIdSeance())!=(seance1.getIdSeance())) {

                TreeItem treeItemSeanceDisponible = new TreeItem("Tutorat le " + seance.getDate() + " à " + seance.getHoraire() +"\n"+
                        "   Besoin: " +
                        seance.getBesoin() +"\n"+
                        "   Salle: " +
                        salle.getSite()+ " " + salle.getBatiment() + salle.getEtage() + salle.getNumeroSalle() +"\n"+
                        "   Matiere: " +
                        matiere.getNomMatiere()+" " + matiere.getSousCategorie() +"\n"+
                        "   Professeur: " + enseignant.getNom() + " " +enseignant.getPrenom());
                afficherSeanceDisponible.getChildren().add(treeItemSeanceDisponible);
            }
        }
    }


    public static void afficheSeanceInscrit(String num_etu,TreeView treeView) {


        List<Seance> listeSeance = SeanceDAO.getSeancesByNumEtu(num_etu);

        TreeItem afficherSeanceInscrit =new  TreeItem("Seance Inscrits");

        treeView.setRoot(afficherSeanceInscrit);
        treeView.setShowRoot(false);


        Seance seance1= SeanceDAO.getIdSeanceByNumEtu(num_etu);



        for(Seance seance :listeSeance) {
            Matiere matiere = MatiereDAO.getMatiereById(seance.getIdMat());

            Salle salle = SalleDAO.getSalleById(seance.getIdSalle());

            Enseignant enseignant = EnseignantDAO.getEnseignantById(seance.getNum_ens());

            if ((seance.getIdSeance())==(seance1.getIdSeance())) {

                TreeItem treeItemSeanceInscrit = new TreeItem("Tutorat le " + seance.getDate() + " à " + seance.getHoraire() +"\n"+
                        "   Besoin: " +
                        seance.getBesoin() +"\n"+
                        "   Salle: " +
                        salle.getSite()+ " " + salle.getBatiment() + salle.getEtage() + salle.getNumeroSalle() +"\n"+
                        "   Matiere: " +
                        matiere.getNomMatiere()+" " + matiere.getSousCategorie() +"\n"+
                        "   Professeur: " + enseignant.getNom() + " " +enseignant.getPrenom());
                afficherSeanceInscrit.getChildren().add(treeItemSeanceInscrit);
            }
        }
    }



    public static void afficherMesTutoratsEnseignant(String num_ens, TreeView treeView){
        List<Seance> listeSeance = SeanceDAO.getSeancesByNumEns(num_ens);


        TreeItem afficherSeance =new  TreeItem("Seance");

        treeView.setRoot(afficherSeance);
        treeView.setShowRoot(false);

        for (Seance seance : listeSeance) {
            Matiere matiere = MatiereDAO.getMatiereById(seance.getIdMat());

            Salle salle = SalleDAO.getSalleById(seance.getIdSalle());

            Enseignant enseignant = EnseignantDAO.getEnseignantById(seance.getNum_ens());

            if ((seance.getIdSeance()) != 0 ) {
                TreeItem treeItemSeance= new TreeItem("Tutorat le " + seance.getDate() + " à " + seance.getHoraire() +"\n"+
                        "   Besoin: " +
                        seance.getBesoin() +"\n"+
                        "   Salle: " +
                        salle.getSite()+ " " + salle.getBatiment() + salle.getEtage() + salle.getNumeroSalle() +"\n"+
                        "   Matiere: " +
                        matiere.getNomMatiere()+" " + matiere.getSousCategorie() +"\n"+
                        "   Professeur: " + enseignant.getNom() + " " +enseignant.getPrenom());

                afficherSeance.getChildren().add(treeItemSeance);

                List<Etudiant> listeEtudiant = EtudiantDAO.getEtudiantsByIdSeance(seance.getIdSeance(),enseignant.getNumero_identification());

                for(Etudiant etudiant:listeEtudiant) {

                    TreeItem treeItemEtudiant= new TreeItem(etudiant.getNumero_identification() + " " + etudiant.getNom() + etudiant.getPrenom());

                    treeItemSeance.getChildren().add(treeItemEtudiant);
                }


            }
        }

    }


}
