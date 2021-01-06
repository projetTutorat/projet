package DAO;

import Modele.Etudiant;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


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


    /**
     * La méthode getEtudiantById est static et retourne le parametre etudiant
     * Elle permet d'obtenir un étudiant grace à son id.
     *
     * @param num
     *          Le numéro de l'Id
     * @return
     * 
     */
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


    /**
     * La méthode getEtudiantsByIdSeance est static et retourne le parametre listeEtudiant.
     *
     * @param idSeance
     *          L'Id de la séance
     * @param num_ens
     *          Le numéro enseignant
     * @return
     */
    public static List<Etudiant> getEtudiantsByIdSeance(int idSeance,String num_ens){
        try {

            Connection connection = ConnexionBDD.getInstance();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM etudiant e INNER JOIN participe_etudiant_seance p ON e.num_etu = p.num_etu INNER JOIN seance s ON p.idSeance = s.idSeance WHERE s.idSeance = ? AND s.num_ens = ?");
            statement.setInt(1,idSeance);
            statement.setString(2,num_ens);

            ResultSet resultSet=  statement.executeQuery();

            List<Etudiant> listeEtudiant = new ArrayList<Etudiant>();

            while (resultSet.next()){
                Etudiant etudiant= new Etudiant();
                etudiant.setNumero_identification(resultSet.getString("num_etu"));
                etudiant.setNom(resultSet.getString("nom"));
                etudiant.setPrenom(resultSet.getString("prenom"));
                etudiant.setDate_de_naissance(resultSet.getString("date_naissance"));
                etudiant.setMot_de_passe(resultSet.getString("mdp"));
                etudiant.setEmail(resultSet.getString("email"));
                etudiant.setNumero_telephone(resultSet.getString("num_tel"));
                etudiant.setNombre_absence(resultSet.getInt("nombreAbsence"));
                listeEtudiant.add(etudiant);
            }

            return listeEtudiant;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * La méthode modifierAbsenceEtudiant n'est pa static et retourne le parametre etudiant.
     * Elle permet de modifier le nombre d'absence d'un etudiant.
     *
     * @param etudiant
     *          L'étudiant
     * @return
     */
    public static Etudiant modifierAbsenceEtudiant(Etudiant etudiant){
        try {
            Connection connection = ConnexionBDD.getInstance();
            PreparedStatement statement = connection.prepareStatement("UPDATE etudiant " +
                    "SET nombreAbsence= ? " +
                    "WHERE num_etu=?;");
            statement.setInt(1,etudiant.getNombre_absence()+1);
            statement.setString(2,etudiant.getNumero_identification());

            statement.execute();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return etudiant;
    }


    /**
     * La méthode ajouterEtudiantSeance est static et retourne le parametre etudiant.
     * Elle permet d'ajouter un étudiant à une séance.
     *
     * @param etudiant
     *          L'étudiant
     * @param idSeance
     *          L'Id de la séance
     * @return
     */
//lors de l'appel de cette methode, appeler methode 'decrementerPlaceSeance'
    public static Etudiant ajouterEtudiantSeance(Etudiant etudiant,int idSeance){

        try {
            Connection connection = ConnexionBDD.getInstance();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO participe_etudiant_seance" +
            		"VALUES" +
                    "(" +
                    "idSeance = ? " +
                    "num_etu = ?" +
                    ")");
            statement.setInt(1,idSeance);
            statement.setString(2,etudiant.getNumero_identification());	

            statement.execute();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return etudiant;
    }

    /**
     * La méthode demissionEtudiantSeance n'est pas static et retourne le parametre etudiant.
     * Elle permet de faire démissioner un étudiant d'une séance.
     *
     * @param etudiant
     *          L'étudiant
     * @param idSeance
     *          L'Id de la séance
     * @return
     */
//lors de l'appel de cette methode, appeler methode 'incrementerPlaceSeance'
    public static Etudiant demissionEtudiantSeance(Etudiant etudiant, int idSeance){
        try {
            Connection connection = ConnexionBDD.getInstance();
            PreparedStatement statement = connection.prepareStatement("DELETE FROM participe_etudiant_seance" +
            		"WHERE num_etu = "+ etudiant.getNumero_identification() +
            		"AND idSeance = "+ idSeance
            		);

            statement.execute();


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return etudiant;
    }







    public Etudiant associerEtudiantFiliere(int idFiliere){
        return null;
    }

}
