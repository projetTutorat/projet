package DAO;

import Modele.Tuteur;

import java.sql.*;

public class TuteurDAO  {



    /**
     * La méthode getTuteurById est static et retourne le parametre tuteur.
     * Elle permet d'obtenir un tuteur grace à son Id.
     *
     * @param num
     *          Le numéro de l'Id
     * @return
     */
    public static Tuteur getTuteurById(String num){
        try {

            Connection connection = ConnexionBDD.getInstance();
            PreparedStatement statement = connection.prepareStatement("SELECT * " +
                    "FROM etudiant " +
                    "INNER JOIN est_tuteur_etudiant " +
                    "ON etudiant.num_etu = est_tuteur_etudiant.num_etu "  +
                    "WHERE etudiant.num_etu=?  ");
            statement.setString(1,num);

            ResultSet resultSet=  statement.executeQuery();

            Tuteur tuteur= new Tuteur();
            while (resultSet.next()){
                tuteur.setNumero_identification(resultSet.getString("num_etu"));
                tuteur.setNom(resultSet.getString("nom"));
                tuteur.setPrenom(resultSet.getString("prenom"));
                tuteur.setDate_de_naissance(resultSet.getString("date_naissance"));
                tuteur.setMot_de_passe(resultSet.getString("mdp"));
                tuteur.setEmail(resultSet.getString("email"));
                tuteur.setNumero_telephone(resultSet.getString("num_tel"));
                tuteur.setNombre_absence(resultSet.getInt("nombreAbsence"));
                tuteur.setIdTuteur(resultSet.getInt("idTuteur"));
            }

            return tuteur;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * La méthode etudiantEstTuteur est static et retourne le parametre tuteur.
     * Elle permet de définir un étudiant en tant que tuteur.
     *
     * @param num
     *          Le numéro de l'Id
     * @return
     */
    public static Tuteur etudiantEstTuteur(String num){
        try {

            Connection connection = ConnexionBDD.getInstance();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM est_tuteur_etudiant WHERE num_etu=?");
            statement.setString(1,num);

            ResultSet resultSet=  statement.executeQuery();

            Tuteur tuteur= new Tuteur();
            while (resultSet.next()){
                tuteur.setNumero_identification(resultSet.getString("num_etu"));
                tuteur.setIdTuteur(resultSet.getInt("idTuteur"));
            }

            return tuteur;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }





}
