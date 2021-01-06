package DAO;

import Modele.Matiere;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MatiereDAO extends DAO<Matiere>  {
    @Override
    public Matiere find(String id) {
        return null;
    }

    @Override
    public Matiere create(Matiere obj) {
        return null;
    }

    @Override
    public Matiere update(Matiere obj) {
        return null;
    }

    @Override
    public void delete(Matiere obj) {

    }


    /**
     * La méthode Matiere est static et retourne le parametre matiere.
     * Elle permet d'obtenir une matière grace à son Id.
     *
     * @param idMat
     *          L'Id de la matière
     * @return
     */
    public static Matiere getMatiereById(int idMat){
        try {

            Connection connection = ConnexionBDD.getInstance();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM matiere WHERE idMat =?");
            statement.setInt(1,idMat);

            ResultSet resultSet=  statement.executeQuery();

            Matiere matiere= new Matiere();
            while (resultSet.next()){
                matiere.setIdMatiere(resultSet.getInt("idMat"));
                matiere.setNomMatiere(resultSet.getString("nomMat"));
                matiere.setSousCategorie(resultSet.getString("sousCategorie"));
            }

            return matiere;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * La méthode getMatiereByNomAndSousCategorie n'est pas static et retourne le parametre matiere.
     * Elle permet d'obtenir une matiere grace à son nom et sa sous-catégorie.
     *
     * @param nomMat
     *          Le nom de la matière
     * @param sousCategorie
     *          La sous-catégorie de la matière
     * @return
     */
    public static Matiere getMatiereByNomAndSousCategorie(String nomMat, String sousCategorie){
        try {

            Connection connection = ConnexionBDD.getInstance();
            PreparedStatement statement = connection.prepareStatement("SELECT * " +
                    "FROM matiere " +
                    "WHERE nomMat =?" +
                    "AND sousCategorie=?");
            statement.setString(1,nomMat);
            statement.setString(2,sousCategorie);


            ResultSet resultSet=  statement.executeQuery();

            Matiere matiere= new Matiere();
            while (resultSet.next()){
                matiere.setIdMatiere(resultSet.getInt("idMat"));
                matiere.setNomMatiere(resultSet.getString("nomMat"));
                matiere.setSousCategorie(resultSet.getString("sousCategorie"));
            }

            return matiere;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * La méthode getMatiereBySousCategorie est static et retourne le parametre matiere.
     * Elle permet d'obtenir une matière grace à une sous-catégorie.
     *
     * @param sousCategorie
     *          La sous-catégorie de la matière
     * @return
     */

    public static Matiere getMatiereBySousCategorie( String sousCategorie){
        try {

            Connection connection = ConnexionBDD.getInstance();
            PreparedStatement statement = connection.prepareStatement("SELECT * " +
                    "FROM matiere " +
                    "WHERE sousCategorie=?");
            statement.setString(1,sousCategorie);


            ResultSet resultSet=  statement.executeQuery();

            Matiere matiere= new Matiere();
            while (resultSet.next()){
                matiere.setIdMatiere(resultSet.getInt("idMat"));
                matiere.setNomMatiere(resultSet.getString("nomMat"));
                matiere.setSousCategorie(resultSet.getString("sousCategorie"));
            }

            return matiere;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * La méthode getMatieresByNumEns est static et retourne le parametre listMatière.
     * Elle permet d'obtenir une matière grace à un numéro enseignant.
     *
     * @param num_ens
     *          Le numéro enseignant
     * @return
     */


    public static List<Matiere> getMatieresByNumEns(String num_ens){
        try {
            Connection connection = ConnexionBDD.getInstance();
            PreparedStatement statement;
            statement = connection.prepareStatement("SELECT * FROM matiere m INNER JOIN enseigne_matiere_enseignant e ON m.idMat = e.idMat WHERE e.num_ens = ?");
            statement.setString(1,num_ens);
            ResultSet resultSet=  statement.executeQuery();

            List<Matiere> listMatiere = new ArrayList<Matiere>();

            while (resultSet.next()){
                Matiere matiere = new Matiere();
                matiere.setIdMatiere(resultSet.getInt("idMat"));
                matiere.setNomMatiere(resultSet.getString("nomMat"));
                matiere.setSousCategorie(resultSet.getString("sousCategorie"));
                listMatiere.add(matiere);

            }
            return listMatiere;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }




    public Matiere associerMatiereProfesseur(Matiere matiere,String num_ens){
        return null;
    }



    public Matiere associerMatiereTuteur(Matiere matiere,int idTuteur){
        return null;
    }

    public Matiere associerMatiereFiliere(Matiere matiere,int idFiliere){
        return null;
    }
}
