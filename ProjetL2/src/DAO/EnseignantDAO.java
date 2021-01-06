package DAO;


import Modele.Enseignant;

import java.sql.*;

public class EnseignantDAO extends DAO<Enseignant> {

    @Override
    public Enseignant find(String id) {
        return null;
    }

    @Override
    public Enseignant create(Enseignant obj) {
        return null;
    }

    @Override
    public Enseignant update(Enseignant obj) {
        return null;
    }

    @Override
    public void delete(Enseignant obj) throws SQLException, ClassNotFoundException {

    }

    /**
     * La méthode Enseignant est static et retourne le parametre enseignant.
     * Elle permet d'obtenir un enseignant via son Id.
     *
     * @param num
     *          Le numero de l'Id
     * @return
     */
    public static Enseignant getEnseignantById(String num){
        try {
            Connection connection = ConnexionBDD.getInstance();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM enseignant WHERE num_ens =?");
            statement.setString(1,num);

            ResultSet resultSet=  statement.executeQuery();

            Enseignant enseignant= new Enseignant();
            while (resultSet.next()){
                enseignant.setNumero_identification(resultSet.getString("num_ens"));
                enseignant.setNom(resultSet.getString("nomEns"));
                enseignant.setPrenom(resultSet.getString("prenomEns"));
                enseignant.setDate_de_naissance(resultSet.getString("date_naissanceEns"));
                enseignant.setMot_de_passe(resultSet.getString("mdp"));
                enseignant.setEmail(resultSet.getString("emailEns"));
                enseignant.setNumero_telephone(resultSet.getString("num_telEns"));
            }

            return enseignant;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }



    public static Enseignant getEnseignantByNomPrenom(String nom, String prenom){
        try {
            Connection connection = ConnexionBDD.getInstance();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM enseignant " +
                    "WHERE nomEns=? " +
                    "AND prenomEns =?");
            statement.setString(1,nom);
            statement.setString(2,prenom);

            ResultSet resultSet=  statement.executeQuery();

            Enseignant enseignant= new Enseignant();
            while (resultSet.next()){
                enseignant.setNumero_identification(resultSet.getString("num_ens"));
                enseignant.setNom(resultSet.getString("nomEns"));
                enseignant.setPrenom(resultSet.getString("prenomEns"));
                enseignant.setDate_de_naissance(resultSet.getString("date_naissanceEns"));
                enseignant.setMot_de_passe(resultSet.getString("mdp"));
                enseignant.setEmail(resultSet.getString("emailEns"));
                enseignant.setNumero_telephone(resultSet.getString("num_telEns"));
            }

            return enseignant;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
