package Controleur;


import DAO.SalleDAO;
import Modele.Salle;
import javafx.scene.control.ComboBox;

import java.sql.SQLException;
import java.util.List;

public class ControleurSalle  {

    /**
     * La mÃ©thode ajouterSalleTPFormulaire est static et ne retourne rien.
     * Elle permet d'ajouter la liste des salles TP dans un comboBox qui se situe dans le formulaire des salles
     *
     * @param listSalle
     *          La liste des salle
     */

    public static void ajouterSalleTPFormulaire(ComboBox listSalle){
        List<Salle> listeSalle = SalleDAO.getSalleBySalleTP();


        for (Salle salle : listeSalle) {
            int index = listSalle.getItems().size();
            listSalle.getItems().add(index, salle.getSite()+" "+salle.getBatiment()+" "+salle.getEtage()+" "+salle.getNumeroSalle());
        }
    }


    /**
     * La mÃ©thode ajouterSalleInfoFormulaire est static et ne retourne rien.
     * Elle permet d'ajouter la liste des salles info dans un comboBox qui se situe dans le formulaire des salles
     *
     * @param listSalle
     *          La liste des salles
     */

    public static void ajouterSalleInfoFormulaire(ComboBox listSalle){
        List<Salle> listeSalle = SalleDAO.getSalleBySalleInfo();


        for (Salle salle : listeSalle) {
            int index = listSalle.getItems().size();
            listSalle.getItems().add(index, salle.getSite()+" "+salle.getBatiment()+" "+salle.getEtage()+" "+salle.getNumeroSalle());
        }
    }


    /**
     * La mÃ©thode ajouterSalleNormaleFormulaire est static et ne retourne rien.
     * Elle permet d'ajouter la liste des salles dans un comboBox qui se situe dans le formulaire des salles
     *
     * @param listSalle
     *          La liste des salles
     */

    public static void ajouterSalleNormaleFormulaire(ComboBox listSalle){
        List<Salle> listeSalle = SalleDAO.getSalleBySalleNormale();


        for (Salle salle : listeSalle) {
            int index = listSalle.getItems().size();
            listSalle.getItems().add(index, salle.getSite()+" "+salle.getBatiment()+" "+salle.getEtage()+" "+salle.getNumeroSalle());
        }
    }


}
