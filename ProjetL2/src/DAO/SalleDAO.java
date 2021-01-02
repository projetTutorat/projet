package DAO;

import Modele.Matiere;
import Modele.Salle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SalleDAO extends DAO<Salle> {
    @Override
    public Salle find(String id) {
        return null;
    }

    @Override
    public Salle create(Salle obj) {
        return null;
    }

    @Override
    public Salle update(Salle obj) {
        return null;
    }

    @Override
    public void delete(Salle obj) {

    }




    public static Salle getSalleById(int idSalle){

        try {

            Connection connection = ConnexionBDD.getInstance();
            PreparedStatement statement = connection.prepareStatement("SELECT * " +
                    "FROM salle " +
                    "WHERE idSalle =?");
            statement.setInt(1,idSalle);


            ResultSet resultSet=  statement.executeQuery();

            Salle salle= new Salle();
            while (resultSet.next()){
                salle.setIdSalle(resultSet.getInt("idSalle"));
                salle.setSite(resultSet.getString("site"));
                salle.setBatiment(resultSet.getString("batiment"));
                salle.setEtage(resultSet.getInt("etage"));
                salle.setNumeroSalle(resultSet.getString("numSalle"));
                salle.setCapaciteMax(resultSet.getInt("capaciteMax"));
                salle.setSalle_info(resultSet.getBoolean("info"));
                salle.setSalle_TP(resultSet.getBoolean("tp"));
            }

            return salle;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }




    public Salle getSalleBySiteBetimentEtageNumeroSalle(String site, String batiment, int etage, String numSalle){
        try {

            Connection connection = ConnexionBDD.getInstance();
            PreparedStatement statement = connection.prepareStatement("SELECT * " +
                    "FROM salle " +
                    "WHERE site =?" +
                    "AND batiment=?" +
                    "AND etage=?" +
                    "AND numSalle=?");
            statement.setString(1,site);
            statement.setString(2,batiment);
            statement.setInt(3,etage);
            statement.setString(4,numSalle);


            ResultSet resultSet=  statement.executeQuery();

            Salle salle= new Salle();
            while (resultSet.next()){
                salle.setIdSalle(resultSet.getInt("idSalle"));
                salle.setSite(resultSet.getString("site"));
                salle.setBatiment(resultSet.getString("batiment"));
                salle.setEtage(resultSet.getInt("etage"));
                salle.setNumeroSalle(resultSet.getString("numSalle"));
                salle.setCapaciteMax(resultSet.getInt("capaciteMax"));
                salle.setSalle_info(resultSet.getBoolean("info"));
                salle.setSalle_TP(resultSet.getBoolean("tp"));
            }

            return salle;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }
}
