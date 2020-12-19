package DAO;


import java.io.IOException;
import java.sql.*;

import static java.sql.JDBCType.NULL;

public class CalendrierDAO {



    public void ajouterSeanceCalendrier(int idSeance) throws ClassNotFoundException, SQLException, IOException{
        String url = "jdbc:mysql://localhost/projet?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String login = "root";
        String password = "";

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, login, password);

        Statement stmt = con.createStatement();


        String sql=
                "SELECT date"+
                        "FROM seance"+
                        "WHERE idSeance= '"+ idSeance+"'";
        ResultSet rs = stmt.executeQuery(sql);

        String sql2 =
                "SELECT horaire"+
                        "FROM seance"+
                        "WHERE idSeance='"+idSeance +"'";
        ResultSet rs2 = stmt.executeQuery(sql2);


        String sql3=
                " INSERT INTO seance"+
                "VALUES"+
                "("+
                NULL+","+
                "SUBSTR(rs,7,10),"+
                "SUBSTR(rs,4,5),"+
                "SUBSTR(rs,1,2),"+
                "SUBSTR(rs2,1,2),"+
                "SUBSTR(rs2,4,5)"+
                ")";
        stmt.executeUpdate(sql3);
    }



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
