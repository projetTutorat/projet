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
            String url = "jdbc:mysql://localhost/projet?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            String login = "root";
            String password = "";

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, login, password);

            Statement stmt = con.createStatement();


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


    	public void afficherSeance(String num) throws ClassNotFoundException, SQLException {
        	
        	String url = "jdbc:mysql://localhost/projet?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            String login = "root";
            String password = "";
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, login, password);

            Statement stmt = con.createStatement();
            Statement stmt2 = con.createStatement();
            Statement stmt3 = con.createStatement();
            Statement stmt4 = con.createStatement();


            String sql = "SELECT * FROM seance S INNER JOIN composee_de_filiere_matiere C ON S.idMat = C.idMat INNER JOIN "
            		+ "appartient_etudiant_filiere A ON C.idFiliere = A.idFiliere INNER JOIN etudiant E ON A.num_etu = E.num_etu WHERE "
            		+ "E.num_etu='"+num+"'";
            ResultSet rs = stmt.executeQuery(sql);
           
            
            while(rs.next()) {
                String sql2 = "SELECT * FROM salle WHERE idSalle='"+rs.getString(7)+"'";
                ResultSet rs2 = stmt2.executeQuery(sql2);
            	if(rs2.next()) {
                    String sql3 = "SELECT * FROM matiere WHERE idMat='"+rs.getString(8)+"'";
                    ResultSet rs3 = stmt3.executeQuery(sql3);
            		if(rs3.next()) {
                        String sql4 = "SELECT * FROM enseignant WHERE num_ens='"+rs.getString(9)+"'";
                        ResultSet rs4 = stmt4.executeQuery(sql4);
            			if(rs4.next()) {
            	            System.out.println("Tutorat le "+rs.getString(2)+" à "+rs.getString(3)+" | "+rs.getString(6)+" Salle:"+
            	                    rs2.getString(2)+rs2.getString(3)+rs2.getString(4)+rs2.getString(5)+
            	                    " Matière: "+rs3.getString(2)+rs3.getString(3)+" Professeur: "+rs4.getString(2)+rs4.getString(3));
            			}
            		}
            	}

            }

        }

    }

