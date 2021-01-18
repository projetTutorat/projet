package DAO;

import Modele.Salle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SalleDAO extends DAO<Salle>  {
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


    /**
     * La méthode getSalleById est static et retourne le parametre salle.
     * Elle permet d'obtenir une salle grace à son Id.
     *
     * @param idSalle
     *          L'Id de la salle
     * @return
     */
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


    /**
     * La méthode getSalleBySiteBatimentEtageNumeroSalle est static et retourne le parametre salle.
     * Elle permet d'obtenir une sale grace à un site, un batiment, un étage et un numéro de salle.
     *
     * @param site
     *          Le site
     * @param batiment
     *          Le batiment
     * @param etage
     *          L'étage
     * @param numSalle
     *          Le numéro de la salle
     * @return
     */
    public static Salle getSalleBySiteBatimentEtageNumeroSalle(String site, String batiment, int etage, String numSalle){
        try {

            Connection connection = ConnexionBDD.getInstance();
            PreparedStatement statement = connection.prepareStatement("SELECT * " +
                    "FROM salle " +
                    "WHERE site =?" +
                    "AND batiment=?" +
                    "AND etage=? " +
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
            return null;
        }
    }

    /**
     * La méthode getSalleBySalleTP est static et retourne le parametre salle.
     * ELle permet d'obtenir les salles Tp parmis toutes les salles.
     *
     * @return
     */
    public static List<Salle> getSalleBySalleTP(){
        try {

            Connection connection = ConnexionBDD.getInstance();
            PreparedStatement statement = connection.prepareStatement("SELECT * " +
                    "FROM salle " +
                    "WHERE tp =1");

            ResultSet resultSet=  statement.executeQuery();


            List<Salle> listeSalle = new ArrayList<Salle>();
            while (resultSet.next()){
                Salle salle = new Salle();
                salle.setIdSalle(resultSet.getInt("idSalle"));
                salle.setSite(resultSet.getString("site"));
                salle.setBatiment(resultSet.getString("batiment"));
                salle.setEtage(resultSet.getInt("etage"));
                salle.setNumeroSalle(resultSet.getString("numSalle"));
                salle.setCapaciteMax(resultSet.getInt("capaciteMax"));
                salle.setSalle_info(resultSet.getBoolean("info"));
                salle.setSalle_TP(resultSet.getBoolean("tp"));
                listeSalle.add(salle);
            }
            return listeSalle;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * La méthode getSalleBySalleInfo est static et retourne le parametre salle.
     * Elle permet d'obtenir les salles Info parmis toutes les salles.
     *
     * @return
     */
    public static List<Salle> getSalleBySalleInfo(){
        try {

            Connection connection = ConnexionBDD.getInstance();
            PreparedStatement statement = connection.prepareStatement("SELECT * " +
                    "FROM salle " +
                    "WHERE info = 1");



            ResultSet resultSet=  statement.executeQuery();

            List<Salle> listeSalle = new ArrayList<Salle>();
            while (resultSet.next()){
                Salle salle = new Salle();
                salle.setIdSalle(resultSet.getInt("idSalle"));
                salle.setSite(resultSet.getString("site"));
                salle.setBatiment(resultSet.getString("batiment"));
                salle.setEtage(resultSet.getInt("etage"));
                salle.setNumeroSalle(resultSet.getString("numSalle"));
                salle.setCapaciteMax(resultSet.getInt("capaciteMax"));
                salle.setSalle_info(resultSet.getBoolean("info"));
                salle.setSalle_TP(resultSet.getBoolean("tp"));
                listeSalle.add(salle);
            }
            return listeSalle;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }




    /**
     * La méthode getSalleBySalleNormale est static et retourne le parametre salle.
     * Elle permet d'obtenir les salles parmis toutes les salles.
     *
     * @return
     */
    public static List<Salle> getSalleBySalleNormale(){
        try {

            Connection connection = ConnexionBDD.getInstance();
            PreparedStatement statement = connection.prepareStatement("SELECT * " +
                    "FROM salle " +
                    "WHERE info = 0 " +
                    "AND tp=0");



            ResultSet resultSet=  statement.executeQuery();

            List<Salle> listeSalle = new ArrayList<Salle>();
            while (resultSet.next()){
                Salle salle = new Salle();
                salle.setIdSalle(resultSet.getInt("idSalle"));
                salle.setSite(resultSet.getString("site"));
                salle.setBatiment(resultSet.getString("batiment"));
                salle.setEtage(resultSet.getInt("etage"));
                salle.setNumeroSalle(resultSet.getString("numSalle"));
                salle.setCapaciteMax(resultSet.getInt("capaciteMax"));
                salle.setSalle_info(resultSet.getBoolean("info"));
                salle.setSalle_TP(resultSet.getBoolean("tp"));
                listeSalle.add(salle);
            }
            return listeSalle;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }




}
