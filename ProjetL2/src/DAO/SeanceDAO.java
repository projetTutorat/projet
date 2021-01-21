package DAO;

import Modele.Seance;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class SeanceDAO extends DAO<Seance> {


    @Override
    public Seance find(String id) {
        return null;
    }

    @Override
    public Seance create(Seance obj) {
        return null;
    }

    @Override
    public Seance update(Seance obj) {
        return null;
    }

    @Override
    public void delete(Seance obj) throws SQLException, ClassNotFoundException {

    }

    /**
     * La méthode getSeanceById est static et retourne le parametre seance.
     * Elle permet d'obtenir une séance grace a son Id.
     *
     * @param idSeance
     *          L'Id de la séance
     * @return
     */
    public static Seance getSeanceById(int idSeance){
        try {
            Connection connection = ConnexionBDD.getInstance();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM seance  WHERE idSeance=?");
            statement.setInt(1,idSeance);
            ResultSet resultSet=  statement.executeQuery();



            Seance seance= new Seance();
            while(resultSet.next()) {
                seance.setIdSeance(resultSet.getInt("idSeance"));
                seance.setDate(resultSet.getString("date"));
                seance.setHoraire(resultSet.getString("horaire"));
                seance.setNbPlaceMax(resultSet.getInt("nbPlaceMax"));
                seance.setNbPlaceRestante(resultSet.getInt("nbPlaceRestante"));
                seance.setBesoin(resultSet.getString("besoin"));
                seance.setIdSalle(resultSet.getInt("idSalle"));
                seance.setIdMat(resultSet.getInt("idMat"));
                seance.setNum_ens(resultSet.getString("num_ens"));
            }

            return seance;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * La méthode getSeancesByNumEns est static et retourne le parametre listeSeance.
     * Elle permet d'obtenir une séance grace à un numéro enseignant.
     *
     * @param num_ens
     *          Le numéro enseignant
     * @return
     */
    public static List<Seance> getSeancesByNumEns(String num_ens){
        try {

            Connection connection = ConnexionBDD.getInstance();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM seance  WHERE num_ens=?");
            statement.setString(1,num_ens);
            ResultSet resultSet=  statement.executeQuery();


            List<Seance> listeSeance = new ArrayList<Seance>();

            while(resultSet.next()) {
                Seance seance= new Seance();
                seance.setIdSeance(resultSet.getInt("idSeance"));
                seance.setDate(resultSet.getString("date"));
                seance.setHoraire(resultSet.getString("horaire"));
                seance.setNbPlaceMax(resultSet.getInt("nbPlaceMax"));
                seance.setNbPlaceRestante(resultSet.getInt("nbPlaceRestante"));
                seance.setBesoin(resultSet.getString("besoin"));
                seance.setIdSalle(resultSet.getInt("idSalle"));
                seance.setIdMat(resultSet.getInt("idMat"));
                seance.setNum_ens(resultSet.getString("num_ens"));
                listeSeance.add(seance);
            }

            return listeSeance;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }
    /**
     * La méthode getSeanceByNumEtu est static et retourne le parametre ListeSeance.
     * Elle permet d'obtenir une séance grace à un numéro étudiant.
     *
     * @param num_etu
     *          Le numéro étudiant
     * @return
     */
    public static List<Seance> getSeancesByNumEtu(String num_etu){
        try {

            Connection connection = ConnexionBDD.getInstance();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM seance S " +
                    "INNER JOIN composee_de_filiere_matiere C " +
                    "ON S.idMat = C.idMat " +
                    "INNER JOIN appartient_etudiant_filiere A " +
                    "ON C.idFiliere = A.idFiliere " +
                    "INNER JOIN etudiant E " +
                    "ON A.num_etu = E.num_etu " +
                    "WHERE E.num_etu=?");
            statement.setString(1,num_etu);
            ResultSet resultSet=  statement.executeQuery();


            List<Seance> ListeSeance= new ArrayList<Seance>();

            while(resultSet.next()) {
                Seance seance= new Seance();
                seance.setIdSeance(resultSet.getInt("idSeance"));
                seance.setDate(resultSet.getString("date"));
                seance.setHoraire(resultSet.getString("horaire"));
                seance.setNbPlaceMax(resultSet.getInt("nbPlaceMax"));
                seance.setNbPlaceRestante(resultSet.getInt("nbPlaceRestante"));
                seance.setBesoin(resultSet.getString("besoin"));
                seance.setIdSalle(resultSet.getInt("idSalle"));
                seance.setIdMat(resultSet.getInt("idMat"));
                seance.setNum_ens(resultSet.getString("num_ens"));
                ListeSeance.add(seance);
            }

            return ListeSeance;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }


    /**
     * La méthode getIdSeanceByNumEtu est static et retourne le parametre seance.
     * Elle permet d'obtenir Id d'une seance grace à un numéro étudiant.
     *
     * @param num_etu
     *          Le numéro étudiant
     * @return
     */
    public static Seance getIdSeanceByNumEtu(String num_etu){
        try {

            Connection connection = ConnexionBDD.getInstance();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM participe_etudiant_seance WHERE num_etu=?");
            statement.setString(1,num_etu);
            ResultSet resultSet=  statement.executeQuery();



            Seance seance= new Seance();
            while(resultSet.next()) {
                seance.setIdSeance(resultSet.getInt("idSeance"));
            }

            return seance;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }
    
    /**
     * La méthode getSeanceByDateHoraireBesoinSalleMatiereNumEns est static et retourne le parametre seance.
     * Elle permet d'obtenir une séance grace à une date, un horaire, un besoin, une salle, une matière et un numéro enseignant.
     *
     * @param date
     *          La date
     * @param horaire
     *          L'horaire
     * @param besoin
     *          Le besoin
     * @param idSalle
     *          L'Id de la salle
     * @param num_ens
     *          Le numéro enseignant
     * @return
     */
    public static Seance getSeanceByDateHoraireBesoinSalleMatiereNumEns(String date, String horaire,String besoin,int idSalle,String num_ens){
        try {

            Connection connection = ConnexionBDD.getInstance();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM seance WHERE  horaire=? AND besoin=? AND idSalle=? AND num_ens=?");

            //statement.setDate(1, Date.valueOf(date));
            statement.setString(1,horaire);
            statement.setString(2,besoin);
            statement.setInt(3,idSalle);
            statement.setString(4,num_ens);
            ResultSet resultSet=  statement.executeQuery();



            Seance seance= new Seance();
            while(resultSet.next()) {
                seance.setIdSeance(resultSet.getInt("idSeance"));
                seance.setDate(resultSet.getString("date"));
                seance.setHoraire(resultSet.getString("horaire"));
                seance.setNbPlaceMax(resultSet.getInt("nbPlaceMax"));
                seance.setNbPlaceRestante(resultSet.getInt("nbPlaceRestante"));
                seance.setBesoin(resultSet.getString("besoin"));
                seance.setIdSalle(resultSet.getInt("idSalle"));
                seance.setIdMat(resultSet.getInt("idMat"));
                seance.setNum_ens(resultSet.getString("num_ens"));
            }
            return seance;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }
    
    /**
     * La méthode creerSeance est static et retourne le parametre seance.
     * Elle permet de creer une séance.
     *
     * @param seance
     *          La séance
     * @return
     */
    public static Seance creerSeance(Seance seance) {
        try {
            Connection connection = ConnexionBDD.getInstance();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO seance " +
                    "("+
                    "date," +
                    "horaire,"+
                    "nbPlaceMax,"+
                    "nbPlaceRestante,"+
                    "besoin,"+
                    "idSalle," +
                    "idMat,"+
                    "num_ens"+
                    ") " +
                    "VALUES "+
                    "(?,?,?,?,?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setDate(1, Date.valueOf(seance.getDate()));
            statement.setString(2,seance.getHoraire());
            statement.setInt(3,seance.getNbPlaceMax());
            statement.setInt(4,seance.getNbPlaceRestante());
            statement.setString(5,seance.getBesoin());
            statement.setInt(6,0);
            statement.setInt(7,seance.getIdMat());
            statement.setString(8,seance.getNum_ens());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seance;
    }

    /**
     * La méthode modifierSeanceAttributionSalle est static et retourne le parametre seance.
     * Elle permet de modifier une séance.
     *
     * @param seance
     *          La séance
     * @param idSalle
     *          L'Id de la salle
     * @return
     */
    public static Seance modifierSeanceAttributionSalle(Seance seance,int idSalle) {
        try {
            Connection connection = ConnexionBDD.getInstance();
            PreparedStatement statement = connection.prepareStatement("UPDATE seance " +
                    "SET " +
                    "idSalle=? "+
                    "WHERE idSeance=?;");
            statement.setInt(1,idSalle);
            statement.setInt(2,seance.getIdSeance());

            statement.execute();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seance;

    }


    /**
     * La méthode supprimerSeance n'est pas static et retourne le parametre seance.
     * Elle permet de supprimer une séance.
     *
     * @param seance
     *          La séance
     * @return
     */
    public Seance supprimerSeance(Seance seance){
    	 try {
             Connection connection = ConnexionBDD.getInstance();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM seance" +
             		"WHERE idSeance = "+ seance.getIdSeance()
             		);

             statement.execute();


         } catch (SQLException e) {
             e.printStackTrace();
         }

         return seance;
     }

    /**
     * La méthode etudiantAppartientSeance est static , boolean et retourne le parametre appartient.
     * Elle permet de vérifier si un étudiant appartient à une séance.
     *
     * @param idSeance
     *          L'Id de la séance
     * @param num_etu
     *          Le numéro étudiant
     * @return
     */
     public static boolean etudiantAppartientSeance(int idSeance, String num_etu){
         try {
             boolean appartient= false;
             Connection connection = ConnexionBDD.getInstance();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM participe_etudiant_seance " +
                     "WHERE idSeance=? " +
                     "AND num_etu=?");
             statement.setInt(1,idSeance);
             statement.setString(2,num_etu);
             ResultSet resultSet=  statement.executeQuery();



             while(resultSet.next()) {
                appartient= true;
             }

             return appartient;
         } catch (SQLException e) {
             e.printStackTrace();
             return false;
         }

     }


     /**
      * La méthode decrementerPlaceSeance est static et retourne le parametre seance.
      * Elle permet de décrémenter la place dans une séance.
      *
      * @param seance
      *          La séance
      * @return
      */
    public static Seance decrementerPlaceSeance(Seance seance){
        try {
            Connection connection = ConnexionBDD.getInstance();
            PreparedStatement statement = connection.prepareStatement("UPDATE seance " +
                    "SET nbPlaceRestante= ? " +
                    "WHERE idSeance=?");
            statement.setInt(1,(seance.getNbPlaceRestante()-1));
            statement.setInt(2,seance.getIdSeance());

            statement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seance;
    }
    
    /**
     * La méthode incrementerPlaceSeance est static et retourne le parametre seance.
     * Elle permet d'incrémenter la place d'une séance.
     *
     * @param seance
     *          La séance
     * @return
     */
    public static Seance incrementerPlaceSeance(Seance seance){
        try {
            Connection connection = ConnexionBDD.getInstance();
            PreparedStatement statement = connection.prepareStatement("UPDATE seance " +
                    "SET nbPlaceRestante= ? " +
                    "WHERE idSeance=?");
            if(seance.getNbPlaceRestante()+1<seance.getNbPlaceMax()) {
            	statement.setInt(1,seance.getNbPlaceRestante()+1);}
            else { 
            	statement.setInt(1,seance.getNbPlaceRestante());
            }
            statement.setInt(2,seance.getIdSeance());

            statement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seance;
    }

    /**
     * La méthode ajouterEtudiantSeance est static et retourne le parametre seance.
     * Elle permet d'ajouter un étduaint à une séance.
     *
     * @param seance
     *          La séance
     * @param num_etu
     *          Le numéro étudiant
     * @return
     */
    public static Seance ajouterEtudiantSeance(Seance seance, String num_etu){
        try {
            Connection connection = ConnexionBDD.getInstance();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO participe_etudiant_seance" +
                    "( idSeance, " +
                    "num_etu )" +
                    "VALUES" +
                    "(?,?)" );
            statement.setInt(1,seance.getIdSeance());
            statement.setString(2,num_etu);

            statement.execute();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seance;
    }

    /**
     * La méthode demissionEtudiantSeance est static et retourne le parametre seance.
     * Elle permet de faire démissioner un étudiant d'une séance.
     *
     * @param seance
     *          La séance
     * @param num_etu
     *          Le numéro étudiant
     * @return
     */
    public static Seance demissionEtudiantSeance(Seance seance, String num_etu){
        try {
            Connection connection = ConnexionBDD.getInstance();
            PreparedStatement statement = connection.prepareStatement("DELETE FROM participe_etudiant_seance WHERE idSeance=? AND num_etu=?");
            statement.setInt(1,seance.getIdSeance());
            statement.setString(2,num_etu);

            statement.execute();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seance;
    }

    /**
     * La méthode ajouterTuteurSeance est static et retourne le parametre seance.
     * Elle permet d'ajouter un tuteur � une séance.
     *
     * @param seance
     *          La séance
     * @param idTuteur
     *          Le numéro étudiant
     * @return
     */

    public static Seance ajouterTuteurSeance(Seance seance, int idTuteur){
        try {
            Connection connection = ConnexionBDD.getInstance();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO s_inscrit_tuteur_seance" +
                    "( idSeance, " +
                    "idTuteur )" +
                    "VALUES" +
                    "(?,?)" );
            statement.setInt(1,seance.getIdSeance());
            statement.setInt(2,idTuteur);

            statement.execute();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seance;
    }


    /**
     * La méthode getSeancesByidTuteur est static et retourne le parametre Listeseance.
     * Elle permet de retourner les informations des s�ances auxquelles un tuteur choisi est inscrit
     *
     * @param idSeance
     *          La séance
     * @return
     */
    public static List<Seance> getSeancesByidTuteur(int idTuteur){
        try {

            Connection connection = ConnexionBDD.getInstance();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM seance S " +
                    "INNER JOIN composee_de_filiere_matiere C " +
                    "ON S.idMat = C.idMat " +
                    "INNER JOIN appartient_etudiant_filiere A " +
                    "ON C.idFiliere = A.idFiliere " +
                    "INNER JOIN etudiant E " +
                    "ON A.num_etu = E.num_etu " +
                    "INNER JOIN est_tuteur_etudiant T " +
                    "ON T.num_etu=E.num_etu " +
                    "WHERE T.idTuteur=?");
            statement.setInt(1,idTuteur);
            ResultSet resultSet=  statement.executeQuery();


            List<Seance> ListeSeance= new ArrayList<Seance>();

            while(resultSet.next()) {
                Seance seance= new Seance();
                seance.setIdSeance(resultSet.getInt("idSeance"));
                seance.setDate(resultSet.getString("date"));
                seance.setHoraire(resultSet.getString("horaire"));
                seance.setNbPlaceMax(resultSet.getInt("nbPlaceMax"));
                seance.setNbPlaceRestante(resultSet.getInt("nbPlaceRestante"));
                seance.setBesoin(resultSet.getString("besoin"));
                seance.setIdSalle(resultSet.getInt("idSalle"));
                seance.setIdMat(resultSet.getInt("idMat"));
                seance.setNum_ens(resultSet.getString("num_ens"));
                ListeSeance.add(seance);
            }

            return ListeSeance;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * La méthode tuteurAppartientSeance est static et retourne le parametre seance.
     * Elle permet de tester grace � la BDD si un tuteur appartient � une s�ance ou non
     *
     * @param idSeance
     *          La séance
     * @param idTuteur
     *          Le numéro étudiant
     * @return
     */

    public static boolean tuteurAppartientSeance(int idSeance, int idTuteur){
        try {
            boolean appartient= false;
            Connection connection = ConnexionBDD.getInstance();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM s_inscrit_tuteur_seance " +
                    "WHERE idSeance=? " +
                    "AND idTuteur=?");
            statement.setInt(1,idSeance);
            statement.setInt(2,idTuteur);
            ResultSet resultSet=  statement.executeQuery();



            while(resultSet.next()) {
                appartient= true;
            }

            return appartient;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }




    /**
     * La méthode getSeancesBySalleManquante est static et retourne le parametre Listeseance.
     * Elle permet de retourner les informations des s�ances auxquelles aucune salle n'est attribu�e

     * @return
     */



    public static List<Seance> getSeancesBySalleManquante(){
        try {

            Connection connection = ConnexionBDD.getInstance();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM seance " +
                    "WHERE idSalle=0");
            ResultSet resultSet=  statement.executeQuery();


            List<Seance> ListeSeance= new ArrayList<Seance>();

            while(resultSet.next()) {
                Seance seance= new Seance();
                seance.setIdSeance(resultSet.getInt("idSeance"));
                seance.setDate(resultSet.getString("date"));
                seance.setHoraire(resultSet.getString("horaire"));
                seance.setNbPlaceMax(resultSet.getInt("nbPlaceMax"));
                seance.setNbPlaceRestante(resultSet.getInt("nbPlaceRestante"));
                seance.setBesoin(resultSet.getString("besoin"));
                seance.setIdSalle(resultSet.getInt("idSalle"));
                seance.setIdMat(resultSet.getInt("idMat"));
                seance.setNum_ens(resultSet.getString("num_ens"));
                ListeSeance.add(seance);
            }

            return ListeSeance;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }
}

