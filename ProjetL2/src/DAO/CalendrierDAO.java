package DAO;


import Modele.Calendrier;
import Modele.Seance;


import java.sql.*;


/**
 * Class DAO sur calendrier
 */
public class CalendrierDAO extends  DAO<Calendrier>{



    @Override
    public Calendrier find(String id) {
        return null;
    }

    @Override
    public Calendrier create(Calendrier obj) {
        return null;
    }

    @Override
    public Calendrier update(Calendrier obj) {
        return null;
    }

    @Override
    public void delete(Calendrier obj) throws SQLException, ClassNotFoundException {

    }


    /**
     * La méthode ajouterSeanceCalendrier n'est pas static et retourne le parametre calendrier.
     * Elle permet d'ajouter une séance sur le calendrier des séances.
     *
     * @param calendrier
     *
     * @return
     */
    public Calendrier ajouterSeanceCalendrier(Calendrier calendrier ) {
        try {
            Connection connection = ConnexionBDD.getInstance();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO calendrier" +
                    "(" +
                    "annnee" +
                    "mois" +
                    "jour" +
                    "heures" +
                    "minutes" +
                    ")" +
                    "VALUES "+
                    "(?,?,?,?,?)");

            statement.setString(1,calendrier.getAnnee());
            statement.setString(2,calendrier.getMois());
            statement.setString(3,calendrier.getJour());
            statement.setString(4,calendrier.getHeures());
            statement.setString(5,calendrier.getMinutes());


            statement.execute();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return calendrier;
    }


    /**
     * La méthode getCalendrierById n'est pas static et retourne le parametre calendrier.
     * Elle permet d'obtenir l'idCalendrier.
     *
     * @param idCalendrier
     *          L'id du calendrier
     * @return
     */
    public Calendrier getCalendrierById(int idCalendrier){
        try {

            Connection connection = ConnexionBDD.getInstance();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM calendrier WHERE idCalendrier =?");
            statement.setInt(1,idCalendrier);

            ResultSet resultSet=  statement.executeQuery();

            Calendrier calendrier= new Calendrier();
            while (resultSet.next()){
                calendrier.setIdCalendrier(resultSet.getInt("idCalendrier"));
                calendrier.setAnnee(resultSet.getString("annee"));
                calendrier.setMois(resultSet.getString("mois"));
                calendrier.setJour(resultSet.getString("jour"));
                calendrier.setHeures(resultSet.getString("heures"));
                calendrier.setMinutes(resultSet.getString("minutes"));
            }

            return calendrier;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * La méthode Calendrier n'est pas static et retourne le parametre calendrier.
     * Elle permet d'obtenir le calendrier grace a une seance.
     *
     * @param seance
     *          La séance
     * @return
     */
        //modifier les substring
    public Calendrier getCalendrierBySeance(Seance seance){
        try {

            Connection connection = ConnexionBDD.getInstance();
            PreparedStatement statement = connection.prepareStatement("SELECT * " +
                    "FROM calendrier " +
                    "WHERE annee =?" +
                    "AND mois =?" +
                    "AND jour=?" +
                    "AND heures=? " +
                    "AND minutes=? ");
            statement.setString(1,(seance.getDate()).substring(7,10));
            statement.setString(2,(seance.getDate()).substring(4,5));
            statement.setString(3,(seance.getDate()).substring(1,2));
            statement.setString(4,(seance.getHoraire()).substring(1,2));
            statement.setString(5,(seance.getHoraire()).substring(4,5));

            ResultSet resultSet=  statement.executeQuery();

            Calendrier calendrier= new Calendrier();
            while (resultSet.next()){
                calendrier.setIdCalendrier(resultSet.getInt("idCalendrier"));
                calendrier.setAnnee(resultSet.getString("annee"));
                calendrier.setMois(resultSet.getString("mois"));
                calendrier.setJour(resultSet.getString("jour"));
                calendrier.setHeures(resultSet.getString("heures"));
                calendrier.setMinutes(resultSet.getString("minutes"));
            }

            return calendrier;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * La méthode afficherCalendrier est static et ne retourne rien.
     * Elle permet d'afficher le calendrier.
     *
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public void afficherCalendrier() throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost/projet+l2?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String login = "root";
        String password = "";

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, login, password);

        Statement stmt = con.createStatement();

        String sql=
                "SELECT idCalendrier, heures " +
                        "FROM calendrier " +
                        "GROUP BY jour";

        ResultSet rs = stmt.executeQuery(sql);
    }


}
