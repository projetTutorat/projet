package Controleur;

import DAO.*;
import Modele.*;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;

/**
 * Classe controleur séance
 */

public class ControleurSeance  {


    /**
     * La méthode afficherSeanceDisponible est static et ne retourne rien.
     * Elle permet d'afficher les séances disponibles dans un treeView en fonction d'un numéro étudiant.
     *
     * @param num_etu
     *          le numero etudiant
     * @param treeView
     *          le treeView
     */
    public static void afficherSeanceDisponible(String num_etu, TreeView treeView)  {

        List<Seance> listeSeance = SeanceDAO.getSeancesByNumEtu(num_etu);

        TreeItem afficherSeanceDisponible =new  TreeItem("Seance Disponibles");

        treeView.setRoot(afficherSeanceDisponible);
        treeView.setShowRoot(false);





        for(Seance seance :listeSeance) {
            Matiere matiere = MatiereDAO.getMatiereById(seance.getIdMat());

            Salle salle = SalleDAO.getSalleById(seance.getIdSalle());

            Enseignant enseignant = EnseignantDAO.getEnseignantById(seance.getNum_ens());

            if (SeanceDAO.etudiantAppartientSeance(seance.getIdSeance(),num_etu)==false && seance.getIdSalle()!=0 && SeanceDAO.tuteurAppartientSeance(seance.getIdSeance(),(TuteurDAO.getTuteurById(num_etu)).getIdTuteur())==false) {

                TreeItem treeItemSeanceDisponible = new TreeItem("Tutorat le " + seance.getDate() + " a� " + seance.getHoraire() +"\n"+
                        "   Besoin: " +
                        seance.getBesoin() +"\n"+
                        "   Salle: " +
                        salle.getSite()+ " " + salle.getBatiment()+ " " + salle.getEtage()+" " + salle.getNumeroSalle() +"\n"+
                        "   Matiere: " +
                        matiere.getNomMatiere()+" " + matiere.getSousCategorie() +"\n"+
                        "   Professeur: " + enseignant.getNom() + " " +enseignant.getPrenom());
                afficherSeanceDisponible.getChildren().add(treeItemSeanceDisponible);
            }
        }
    }


    /**
     * La méthode afficheSeanceInscrit est static et ne retourne rien.
     * Elle permet d'afficher les séances inscrites dans un treeView en fonction d'un numéro étudiant.
     *
     * @param num_etu
     *          Le numéro étudiant
     * @param treeView
     *          Le treeView
     */
    public static void afficheSeanceInscrit(String num_etu,TreeView treeView) {


        List<Seance> listeSeance = SeanceDAO.getSeancesByNumEtu(num_etu);

        TreeItem afficherSeanceInscrit =new  TreeItem("Seance Inscrits");

        treeView.setRoot(afficherSeanceInscrit);
        treeView.setShowRoot(false);





        for(Seance seance :listeSeance) {
            Matiere matiere = MatiereDAO.getMatiereById(seance.getIdMat());

            Salle salle = SalleDAO.getSalleById(seance.getIdSalle());

            Enseignant enseignant = EnseignantDAO.getEnseignantById(seance.getNum_ens());

            if (SeanceDAO.etudiantAppartientSeance(seance.getIdSeance(),num_etu)==true && seance.getIdSalle()!=0) {

                TreeItem treeItemSeanceInscrit = new TreeItem("Tutorat le " + seance.getDate() + " a� " + seance.getHoraire() +"\n"+
                        "   Besoin: " +
                        seance.getBesoin() +"\n"+
                        "   Salle: " +
                        salle.getSite()+ " " + salle.getBatiment()+ " " + salle.getEtage()+" " + salle.getNumeroSalle() +"\n"+
                        "   Matiere: " +
                        matiere.getNomMatiere()+" " + matiere.getSousCategorie() +"\n"+
                        "   Professeur: " + enseignant.getNom() + " " +enseignant.getPrenom());
                afficherSeanceInscrit.getChildren().add(treeItemSeanceInscrit);
            }
        }
    }


    /**
     * La méthode afficherMesTutoratsEnseignant est static et ne retourne rien.
     * Elle permet d'afficher les tutorats dans un treeView en fonction d'un numéro enseignant.
     *
     * @param num_ens
     *          Le numéro enseignant
     * @param treeView
     *          Le treeView
     */
    public static void afficherMesTutoratsEnseignant(String num_ens, TreeView treeView){
        List<Seance> listeSeance = SeanceDAO.getSeancesByNumEns(num_ens);


        TreeItem afficherSeance =new  TreeItem("Seance");

        treeView.setRoot(afficherSeance);
        treeView.setShowRoot(false);

        for (Seance seance : listeSeance) {
            Matiere matiere = MatiereDAO.getMatiereById(seance.getIdMat());

            Salle salle = SalleDAO.getSalleById(seance.getIdSalle());

            Enseignant enseignant = EnseignantDAO.getEnseignantById(seance.getNum_ens());

            if ((seance.getIdSeance()) != 0 && seance.getIdSalle()!=0 ) {
                TreeItem treeItemSeance= new TreeItem("Tutorat le " + seance.getDate() + " a� " + seance.getHoraire() +"\n"+
                        "   Besoin: " +
                        seance.getBesoin() +"\n"+
                        "   Salle: " +
                        salle.getSite()+ " " + salle.getBatiment()+ " " + salle.getEtage()+" " + salle.getNumeroSalle() +"\n"+
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



    /**
     * La méthode ajouterMatFormulaire est static et ne retourne rien.
     * Elle permet d'ajouter la liste des matieres dans un comboBox qui se situe dans le formulaire des matière à partir d'un numéro enseignant
     *
     * @param num_ens
     *          Le numéro enseignant
     * @param listMat
     *          La liste des matière
     * @throws SQLException
     */

    public static void ajouterMatFormulaire(String num_ens, ComboBox listMat) throws SQLException {
        List<Matiere> listMatieres = MatiereDAO.getMatieresByNumEns(num_ens);


        for (Matiere matiere : listMatieres) {
            int index = listMat.getItems().size();
            listMat.getItems().add(index, matiere.getSousCategorie());
        }
    }
    
    /**
     * La méthode creerSeance est static et ne retourne rien.
     * Elle permet de creer une séance à partir d'un formulaire grace à un numéro enseignant.
     *
     * @param num_ens
     *          Le numéro enseignant
     * @param datePickerSeance
     *          Le datePicker pour la date de la séance
     * @param listMat
     *          La liste des matières dans un comboBox
     * @param textNbEtuMax
     *          Le textField pour définir le nombre d'étudiants max
     * @param textHeure
     *          Le textField pour définir l'heure de la séance
     * @param erreur
     *          Renvois un message d'erreur si le formulaire est mal remplit
     * @param rbInfo
     *          Le radioButton pour choisir l'option "salle info"
     * @param rbTp
     *          Le radioButton pour choisir l'option "salle TP"
     * @param buttonCreerSeance
     *          Le Button pour creer la séance en fonction des attributs remplis
     */
    
    public static void creerSeance(String num_ens, DatePicker datePickerSeance, ComboBox listMat, TextField textNbEtuMax, TextField textHeure, Label erreur, RadioButton rbInfo, RadioButton rbTp, Button buttonCreerSeance)  {

        try {
                Matiere matiere = MatiereDAO.getMatiereBySousCategorie(String.valueOf(listMat.getValue()));

                Seance seance = new Seance();
                LocalDate data=datePickerSeance.getValue();

                seance.setDate(String.valueOf(data));
                seance.setHoraire(textHeure.getText());
                seance.setNbPlaceMax(Integer.parseInt(textNbEtuMax.getText()));
                seance.setNbPlaceRestante(Integer.parseInt(textNbEtuMax.getText()));
                seance.setIdMat(matiere.getIdMatiere());
                seance.setNum_ens(num_ens);

                if(rbTp.isSelected()) {
                    seance.setBesoin("salle tp");
                }
                else if (rbInfo.isSelected()) {
                    seance.setBesoin("salle info");

                }
                else {
                    seance.setBesoin("Pas de besoin");
                }

                SeanceDAO.creerSeance(seance);



                Stage interfaceCS = (Stage) buttonCreerSeance.getScene().getWindow();
                interfaceCS.close();

                Alert a = new Alert(Alert.AlertType.NONE, "S�ance cr��e avec succ�s!");
                a.setAlertType(Alert.AlertType.CONFIRMATION);
                a.show();


        }catch(Exception e) {
            erreur.setText("Erreur veuillez réessayer !");
        }
    }




    /**
     * La méthode afficherSeanceDisponibleTuteur est static et ne retourne rien.
     * Elle permet d'afficher les tutorats disponibles dans un treeView en fonction d'un numéro etudiant.
     * @param num_etu
     * @param treeView
     */
    public static void afficherSeanceDisponibleTuteur(String num_etu, TreeView treeView)  {

        Tuteur tuteur = TuteurDAO.getTuteurById(num_etu);

        List<Seance> listeSeance = SeanceDAO.getSeancesByNumEtu(num_etu);

        TreeItem afficherSeanceDisponible =new  TreeItem("Seance Disponibles");

        treeView.setRoot(afficherSeanceDisponible);
        treeView.setShowRoot(false);





        for(Seance seance :listeSeance) {
            Matiere matiere = MatiereDAO.getMatiereById(seance.getIdMat());

            Salle salle = SalleDAO.getSalleById(seance.getIdSalle());

            Enseignant enseignant = EnseignantDAO.getEnseignantById(seance.getNum_ens());

            if (SeanceDAO.tuteurAppartientSeance(seance.getIdSeance(),tuteur.getIdTuteur())==false && seance.getIdSalle()!=0 && SeanceDAO.etudiantAppartientSeance(seance.getIdSeance(),tuteur.getNumero_identification())==false) {

                TreeItem treeItemSeanceDisponible = new TreeItem("Tutorat le " + seance.getDate() + " a� " + seance.getHoraire() +"\n"+
                        "   Besoin: " +
                        seance.getBesoin() +"\n"+
                        "   Salle: " +
                        salle.getSite()+ " " + salle.getBatiment()+ " " + salle.getEtage()+" " + salle.getNumeroSalle() +"\n"+
                        "   Matiere: " +
                        matiere.getNomMatiere()+" " + matiere.getSousCategorie() +"\n"+
                        "   Professeur: " + enseignant.getNom() + " " +enseignant.getPrenom());
                afficherSeanceDisponible.getChildren().add(treeItemSeanceDisponible);
            }
        }
    }


    /**
     * La méthode afficheSeanceInscritTuteur est static et ne retourne rien.
     * Elle permet d'afficher les s�ances dans un treeView en fonction d'un numéro etudiant.
     * @param num_etu
     * @param treeView
     */
    public static void afficheSeanceInscritTuteur(String num_etu,TreeView treeView) {


        Tuteur tuteur = TuteurDAO.getTuteurById(num_etu);

        List<Seance> listeSeance = SeanceDAO.getSeancesByNumEtu(num_etu);

        TreeItem afficherSeanceInscrit =new  TreeItem("Seance Inscrits");

        treeView.setRoot(afficherSeanceInscrit);
        treeView.setShowRoot(false);





        for(Seance seance :listeSeance) {
            Matiere matiere = MatiereDAO.getMatiereById(seance.getIdMat());

            Salle salle = SalleDAO.getSalleById(seance.getIdSalle());

            Enseignant enseignant = EnseignantDAO.getEnseignantById(seance.getNum_ens());

            if (SeanceDAO.tuteurAppartientSeance(seance.getIdSeance(),tuteur.getIdTuteur())==true && seance.getIdSalle()!=0) {

                TreeItem treeItemSeanceInscrit = new TreeItem("Tutorat le " + seance.getDate() + " a� " + seance.getHoraire() +"\n"+
                        "   Besoin: " +
                        seance.getBesoin() +"\n"+
                        "   Salle: " +
                        salle.getSite()+ " " + salle.getBatiment()+ " " + salle.getEtage()+" " + salle.getNumeroSalle() +"\n"+
                        "   Matiere: " +
                        matiere.getNomMatiere()+" " + matiere.getSousCategorie() +"\n"+
                        "   Professeur: " + enseignant.getNom() + " " +enseignant.getPrenom());
                afficherSeanceInscrit.getChildren().add(treeItemSeanceInscrit);
            }
        }
    }



    /**
     * La méthode afficheSeanceSansSalle est static et ne retourne rien.
     * Elle permet d'afficher les s�ances dans un treeView.
     * @param treeView
     */

    public static void afficheSeanceSansSalle(TreeView treeView) {
        List<Seance> listeSeance = SeanceDAO.getSeancesBySalleManquante();

        TreeItem afficherSeanceInscrit = new TreeItem("Seance Sans Salle");

        treeView.setRoot(afficherSeanceInscrit);
        treeView.setShowRoot(false);


        for (Seance seance : listeSeance) {
            Matiere matiere = MatiereDAO.getMatiereById(seance.getIdMat());

            Salle salle = SalleDAO.getSalleById(seance.getIdSalle());

            Enseignant enseignant = EnseignantDAO.getEnseignantById(seance.getNum_ens());


            if (seance.getIdSalle()==0) {

                TreeItem treeItemSeanceInscrit = new TreeItem("Tutorat le " + seance.getDate() + " a� " + seance.getHoraire() +"\n"+
                        "   Besoin: " +
                        seance.getBesoin() +"\n"+
                        "   Salle: " +
                        salle.getSite()+ " " + salle.getBatiment()+ " " + salle.getEtage()+" " + salle.getNumeroSalle() +"\n"+
                        "   Matiere: " +
                        matiere.getNomMatiere()+" " + matiere.getSousCategorie() +"\n"+
                        "   Professeur: " + enseignant.getNom() + " " +enseignant.getPrenom());
                afficherSeanceInscrit.getChildren().add(treeItemSeanceInscrit);
            }
        }
    }
    /**
     * La méthode ajouterSalleASeance est static et ne retourne rien.
     * Elle permet d'ajouter une salle � une seance pass�e en parametre
     * @param listeSalle
     * @param seance
     * @param buttonAjouterSalle
     */
    public static void ajouterSalleASeance(ComboBox listeSalle,Seance seance, Button buttonAjouterSalle){
        String salleSelectionne = String.valueOf(listeSalle.getValue());
        Salle salle= SalleDAO.getSalleBySiteBatimentEtageNumeroSalle(salleSelectionne.split(" ")[0],salleSelectionne.split(" ")[1], Integer.parseInt(salleSelectionne.split(" ")[2]),salleSelectionne.split(" ")[3]);
        SeanceDAO.modifierSeanceAttributionSalle(seance,salle.getIdSalle());


        Stage interfaceAS = (Stage) buttonAjouterSalle.getScene().getWindow();
        interfaceAS.close();
    }

}
