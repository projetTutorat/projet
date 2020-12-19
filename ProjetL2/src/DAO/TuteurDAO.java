package DAO;

import Modele.Tuteur;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TuteurDAO  {

    public void ajouterTuteurSeance(int idSeance,int idTuteur) throws SQLException, ClassNotFoundException {

        String url = "jdbc:mysql://localhost/projet?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
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

}
