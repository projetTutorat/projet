package DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.scene.control.Label;


public class EtudiantDAO {
	


    public void modifierEtudiant(int nombreAbsence,String num_etu) throws ClassNotFoundException, SQLException {

        String url = "jdbc:mysql://localhost/projet?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String login = "root";
        String password = "";

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, login, password);

        Statement stmt = con.createStatement();



        String sql1= "UPDATE etudiant" +
                "SET" +
                "(" +
                "nombreAbsence='"+ nombreAbsence+1+"'" +
                ")" +
                "WHERE num_etu='"+num_etu+"'";
        stmt.executeUpdate(sql1);
    }
   

}
