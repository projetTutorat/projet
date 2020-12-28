package DAO;

import Modele.Etudiant;
import java.sql.*;


public class EtudiantDAO extends DAO<Etudiant> {


    @Override
    public Etudiant find(String id) {
        return null;
    }

    @Override
    public Etudiant create(Etudiant obj) {
        return null;
    }

    @Override
    public Etudiant update(Etudiant obj) {
        return null;
    }

    @Override
    public void delete(Etudiant obj) throws SQLException, ClassNotFoundException {

    }




    public static Etudiant getEtudiantById(String num){
        try {

            Connection connection = ConnexionBDD.getInstance();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM etudiant WHERE num_etu =?");
            statement.setString(1,num);

            ResultSet resultSet=  statement.executeQuery();

            Etudiant etudiant= new Etudiant();
            while (resultSet.next()){
                etudiant.setNumero_identification(resultSet.getString("num_etu"));
                etudiant.setNom(resultSet.getString("nom"));
                etudiant.setPrenom(resultSet.getString("prenom"));
                etudiant.setDate_de_naissance(resultSet.getString("date_naissance"));
                etudiant.setMot_de_passe(resultSet.getString("mdp"));
                etudiant.setEmail(resultSet.getString("email"));
                etudiant.setNumero_telephone(resultSet.getString("num_tel"));
                etudiant.setNombre_absence(resultSet.getInt("nombreAbsence"));
            }

            return etudiant;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }





    public Etudiant modifierAbsenceEtudiant(Etudiant etudiant){
        try {
            Connection connection = ConnexionBDD.getInstance();
            PreparedStatement statement = connection.prepareStatement("UPDATE etudiant" +
                    "SET" +
                    "(" +
                    "nombreAbsence= ? " +
                    ")" +
                    "WHERE num_etu=?;");
            statement.setInt(1,etudiant.getNombre_absence()+1);
            statement.setString(2,etudiant.getNumero_identification());

            statement.execute();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return etudiant;
    }



    public Etudiant ajouterEtudiantSeance(Etudiant etudiant){

        try {
            Connection connection = ConnexionBDD.getInstance();
            PreparedStatement statement = connection.prepareStatement("");

            statement.execute();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return etudiant;
    }

    public Etudiant demissionEtudiantSeance(Etudiant etudiant){
        try {
            Connection connection = ConnexionBDD.getInstance();
            PreparedStatement statement = connection.prepareStatement("");

            statement.execute();


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return etudiant;
    }





    public Etudiant associerEtudiantFiliere(){
        return null;
    }

}
