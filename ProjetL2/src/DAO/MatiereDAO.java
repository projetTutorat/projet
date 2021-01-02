package DAO;

import Modele.Etudiant;
import Modele.Matiere;

import java.sql.*;

public class MatiereDAO extends DAO<Matiere> {
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



    public Matiere getMatiereByNomAndSousCategorie(String nomMat, String sousCategorie){
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
        }

        return null;
    }




    public Matiere associerMatiereProfesseur(){
        return null;
    }



    public Matiere associerMatiereTuteur(){
        return null;
    }

    public Matiere associerMatiereFiliere(){
        return null;
    }
}
