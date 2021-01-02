package DAO;

import Modele.Tuteur;

import java.sql.*;

public class TuteurDAO  {

    public void ajouterTuteurSeance(int idSeance,int idTuteur) throws SQLException, ClassNotFoundException {

        String url = "jdbc:mysql://localhost/projet+l2?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String login = "root";
        String password = "";

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, login, password);

        Statement stmt = con.createStatement();

        String sql="INSERT INTO s_inscrit_tuteur_seance" +
                "VALUES" +
                "(" +
                "'"+idSeance+"'," +
                "'"+idTuteur+"'" +
                ")";
        stmt.executeUpdate(sql);



    }



    public static Tuteur getTuteurById(String num){
        try {

            Connection connection = ConnexionBDD.getInstance();
            PreparedStatement statement = connection.prepareStatement("SELECT * " +
                    "FROM etudiant" +
                    "INNER JOIN est_tuteur_etudiant" +
                    "ON etudiant.num_etu =est_tuteur_etudiant.num_etu "  +
                    "WHERE etudiant.num_etu = ?  ");
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
                tuteur.setNombre_absence(resultSet.getInt("idTuteur"));
            }

            return tuteur;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

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
