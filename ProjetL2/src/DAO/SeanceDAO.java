package DAO;

import Modele.Seance;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.sql.*;

import static java.sql.JDBCType.NULL;

public class SeanceDAO {


     public void creerSeance(TextField textMatiere, TextField textSousCategorie, TextField textNbPlaceMax,TextField textNbPlaceRestant, TextField textBesoin, TextField textDate,TextField textHoraire,String num_ens) throws SQLException, ClassNotFoundException {
            String url = "jdbc:mysql://localhost/projet?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            String login = "root";
            String password = "";

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, login, password);

            Statement stmt = con.createStatement();
            Statement stmt2 = con.createStatement();


            String sql=
                    "SELECT idMat"+
                    "FROM matiere"+
                    "WHERE nomMat= '" +textMatiere.getText()+"'"+
                    "AND sousCategorie='"+ textSousCategorie.getText()+"'";
            ResultSet rs = stmt.executeQuery(sql);

            String sql2 =
                    "INSERT INTO seance"+
                    "VALUES (" +
                            "''"+NULL+"'," +
                            "'" +textDate.getText()+"'," +
                            "'" +textHoraire.getText()+"'," +
                            "'"+Integer.parseInt(textNbPlaceMax.getText())+"'," +
                            "'" +Integer.parseInt(textNbPlaceRestant.getText())+"'," +
                            "'" +textBesoin.getText()+"'," +
                            "'" +NULL+"'," +
                            "'" +rs+"'," +
                            "'"+ num_ens+"')";

            stmt2.executeUpdate(sql2);

        }



        public void modifierSeance(TextField textDate, TextField textHoraire,TextField textNbPlaceMax, TextField textBesoin,int idSalle,int idSeance) throws ClassNotFoundException, SQLException {
            String url = "jdbc:mysql://localhost/projet+l2?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            String login = "root";
            String password = "";

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, login, password);

            Statement stmt = con.createStatement();
            Statement stmt2 = con.createStatement();


            String sql=
                    "UPDATE " +
                     "seance " +
                     "SET " +
                    "(" +
                    "date= '" +textDate.getText()+"'"+
                     "horaire= '" +textHoraire.getText()+"'"+
                    "nbPlaceMax= '"+ Integer.parseInt(textNbPlaceMax.getText())+"'"+
                    "besoin='"+textBesoin.getText()+","+
                     "idSalle='"+idSalle+"',"+
                     ")"+
                     "WHERE idSeance= '"+idSeance+"'";
            stmt.executeUpdate(sql);

        }



        public void supprimerSeance(){

        }


        public void afficherSeance(String nomFiliere) throws SQLException, ClassNotFoundException {

            String url = "jdbc:mysql://localhost/projet+l2?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            String login = "root";
            String password = "";

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, login, password);

            Statement stmt = con.createStatement();

         String sql ="SELECT date, horaire, nbPlaceRestante, nomMat" +
                 "FROM seance" +
                 "INNER JOIN matiere" +
                 "ON  matiere.idMat=seance.idMat" +
                 "INNER JOIN composee_de_filiere_matiere" +
                 "ON matiere.idMat=  composee_de_filiere_matiere.idMat" +
                 "INNER JOIN filiere" +
                 "ON composee_de_filiere_matiere.idFiliere = filiere.idFiliere" +
                 "WHERE nomFiliere='"+nomFiliere+"'";
            ResultSet rs = stmt.executeQuery(sql);


        }

    }

