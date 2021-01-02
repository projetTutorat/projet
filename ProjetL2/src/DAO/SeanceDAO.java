package DAO;

import Modele.Etudiant;
import Modele.Seance;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.*;
import java.time.LocalDate;
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

    public static Seance getIdSeanceByNumEns(String num_ens){
        try {

            Connection connection = ConnexionBDD.getInstance();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM participe_etudiant_seance WHERE num_etu=?");
            statement.setString(1,num_ens);
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

    public Seance creerSeance(Seance seance) {
        try {
            Connection connection = ConnexionBDD.getInstance();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO seance" +
                    "(" +
                    "date " +
                    "horaire"+
                    "nbPlaceMax"+
                    "nbPlaxeRestante"+
                    "besoin"+
                    "idMat"+
                    "num_ens"+
                    ")" +
                    "VALUES "+
                    "(?,?,?,?,?,?,?)");
            statement.setString(1,seance.getDate());
            statement.setString(2,seance.getHoraire());
            statement.setInt(3,seance.getNbPlaceMax());
            statement.setInt(4,seance.getNbPlaceRestante());
            statement.setString(5,seance.getBesoin());
            statement.setInt(6,seance.getIdMat());
            statement.setString(7,seance.getNum_ens());


            statement.execute();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seance;
    }



    public Seance getSeanceByNumEnseignant(String num_ens){
        return null;
    }

    public Seance modifierSeanceAttributionSalle(Seance seance,int idSalle) {
        try {
            Connection connection = ConnexionBDD.getInstance();
            PreparedStatement statement = connection.prepareStatement("UPDATE seance" +
                    "SET" +
                    "(" +
                    "date= ? " +
                    "horaire= ?"+
                    "nbPlaceMax=?"+
                    "nbPlcaxeRestante=?"+
                    "besoin=?"+
                    "idSalle=?"+
                    ")" +
                    "WHERE idSeance=?;");
            statement.setString(1,seance.getDate());
            statement.setString(2,seance.getHoraire());
            statement.setInt(3,seance.getNbPlaceMax());
            statement.setInt(4,seance.getNbPlaceRestante());
            statement.setString(5,seance.getBesoin());
            statement.setInt(6,idSalle);
            statement.setInt(7,seance.getIdSeance());

            statement.execute();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seance;

    }



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

    




    public Seance afficheSeanceInscrit(String num_etu) {
        try {
            Connection connection = ConnexionBDD.getInstance();
            PreparedStatement statement;
            statement = connection.prepareStatement("SELECT * FROM seance S " +
                    "INNER JOIN composee_de_filiere_matiere C " +
                    "ON S.idMat = C.idMat " +
                    "INNER JOIN appartient_etudiant_filiere A " +
                    "ON C.idFiliere = A.idFiliere " +
                    "INNER JOIN etudiant E " +
                    "ON A.num_etu = E.num_etu " +
                    "WHERE E.num_etu=?");

            statement.setString(1,num_etu);
            ResultSet resultSet=  statement.executeQuery();

            Seance seance= new Seance();

            while(resultSet.next()) {
                PreparedStatement statement2 = connection.prepareStatement("SELECT * FROM salle WHERE idSalle=?");
                statement2.setLong(1, resultSet.getInt("idSalle"));
                ResultSet resultSet2=  statement2.executeQuery();
                if(resultSet2.next()) {
                    PreparedStatement statement3 = connection.prepareStatement("SELECT * FROM matiere WHERE idMat=?");
                    statement3.setLong(1, resultSet.getInt("idMat"));
                    ResultSet resultSet3=  statement3.executeQuery();
                    if(resultSet3.next()) {
                        PreparedStatement statement4 = connection.prepareStatement("SELECT * FROM enseignant WHERE num_ens=?");
                        statement4.setString(1, resultSet.getString("num_ens"));
                        ResultSet resultSet4=  statement4.executeQuery();
                        if(resultSet4.next()) {
                            PreparedStatement statement5 = connection.prepareStatement("SELECT * FROM participe_etudiant_seance WHERE num_etu=?");
                            statement5.setString(1,num_etu);
                            ResultSet resultSet5=statement5.executeQuery();
                            if(resultSet5.next()) {
                                if(resultSet5.getInt("idSeance")==(resultSet.getInt("idSeance"))) {
                                    System.out.println("Tutorat le " + resultSet.getString("date") + " Ã Â  " + resultSet.getString("horaire") + " | " + resultSet.getString("besoin") + " Salle:" +
                                            resultSet2.getString("site") + resultSet2.getString("batiment") + resultSet2.getInt("etage") + resultSet2.getInt("numSalle") +
                                            " MatiÃ¨re: " + resultSet3.getString("nomMat") + resultSet3.getString("sousCategorie") + " Professeur: " + resultSet4.getString("nomEns")
                                            + resultSet4.getString("prenomEns"));

                                }
                            }
                        }
                    }
                }
            }

            return seance;
        } catch (SQLException e) {
            e.printStackTrace();
        }





        return null;
    }

    public Seance afficheMesTutoratsEnseignant(String num_ens) {
        try {
            Connection connection = ConnexionBDD.getInstance();
            PreparedStatement statement;
            statement = connection.prepareStatement("SELECT * FROM seance S WHERE num_ens=?");

            statement.setString(1, num_ens);
            ResultSet resultSet = statement.executeQuery();

            Seance seance = new Seance();

            while (resultSet.next()) {
                PreparedStatement statement2 = connection.prepareStatement("SELECT * FROM salle WHERE idSalle=?");
                statement2.setLong(1, resultSet.getInt("idSalle"));
                ResultSet resultSet2 = statement2.executeQuery();
                if (resultSet2.next()) {
                    PreparedStatement statement3 = connection.prepareStatement("SELECT * FROM matiere WHERE idMat=?");
                    statement3.setLong(1, resultSet.getInt("idMat"));
                    ResultSet resultSet3 = statement3.executeQuery();
                    if (resultSet3.next()) {
                        PreparedStatement statement4 = connection.prepareStatement("SELECT * FROM enseignant WHERE num_ens=?");
                        statement4.setString(1, resultSet.getString("num_ens"));
                        ResultSet resultSet4 = statement4.executeQuery();
                        if (resultSet4.next()) {
                            System.out.println("Tutorat le " + resultSet.getString("date") + " Ã Â  " + resultSet.getString("horaire") + " | " + resultSet.getString("besoin") + " Salle:" +
                                    resultSet2.getString("site") + resultSet2.getString("batiment") + resultSet2.getInt("etage") + resultSet2.getInt("numSalle") +
                                    " MatiÃ¨re: " + resultSet3.getString("nomMat") + resultSet3.getString("sousCategorie") + " Professeur: " + resultSet4.getString("nomEns")
                                    + resultSet4.getString("prenomEns"));
                            PreparedStatement statement5 = connection.prepareStatement("SELECT * FROM etudiant e INNER JOIN participe_etudiant_seance p ON e.num_etu = p.num_etu INNER JOIN seance s ON p.idSeance = s.idSeance WHERE s.idSeance = ? AND s.num_ens = ?");
                            statement5.setLong(1, resultSet.getInt("idSeance"));
                            statement5.setString(2, num_ens);

                            ResultSet resultSet5 = statement5.executeQuery();
                            while (resultSet5.next()) {
                                System.out.println(resultSet5.getString("num_etu") + " " + resultSet5.getString("prenom") + resultSet5.getString("nom"));
                                System.out.println();
                            }
                        }
                    }
                }
            }

            return seance;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public Seance decrementerPlaceSeance(Seance seance){
        try {
            Connection connection = ConnexionBDD.getInstance();
            PreparedStatement statement = connection.prepareStatement("UPDATE seance" +
                    "SET" +
                    "(" +
                    "nbPlaceRestante= ? " +
                    ")" +
                    "WHERE idSeance=?;");
            statement.setInt(1,seance.getNbPlaceRestante()-1);
            statement.setInt(2,seance.getIdSeance());

            statement.execute();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seance;
    }
    
    public Seance incrementerPlaceSeance(Seance seance){
        try {
            Connection connection = ConnexionBDD.getInstance();
            PreparedStatement statement = connection.prepareStatement("UPDATE seance" +
                    "SET" +
                    "(" +
                    "nbPlaceRestante= ? " +
                    ")" +
                    "WHERE idSeance=?;");
            if(seance.getNbPlaceRestante()+1<seance.getNbPlaceMax()) {
            	statement.setInt(1,seance.getNbPlaceRestante()+1);}
            else { 
            	statement.setInt(1,seance.getNbPlaceRestante());
            }
            statement.setInt(2,seance.getIdSeance());

            statement.execute();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seance;
    }
    

    
      public void ajouterMatFormulaire(String num_ens, ComboBox listMat) throws SQLException {
            Connection connection = ConnexionBDD.getInstance();
            PreparedStatement statement;
            statement = connection.prepareStatement("SELECT * FROM matiere m INNER JOIN enseigne_matiere_enseignant e ON m.idMat = e.idMat WHERE e.num_ens = ?");

            statement.setString(1,num_ens);
            ResultSet resultSet=  statement.executeQuery();


            while(resultSet.next()) {
            	int index = listMat.getItems().size();
            	listMat.getItems().add(index, resultSet.getString("sousCategorie"));
            }
    }
    
    public void creerSeance(String num_ens, DatePicker datePickerSeance, ComboBox listMat, TextField textNbEtuMax, 
    		TextField textBesoin, TextField textHeure, Label erreur, RadioButton rbInfo, RadioButton rbTp, Button buttonCreerSeance) throws SQLException  {
    	
    	try {
    	 Connection connection = ConnexionBDD.getInstance();
         PreparedStatement statement1;
         statement1 = connection.prepareStatement("SELECT * FROM matiere WHERE sousCategorie = ?");

         String mat = (String) listMat.getValue();
         statement1.setString(1,mat);
         ResultSet resultSet1=  statement1.executeQuery();
         
         
         
         if(resultSet1.next()) {
        	 

    	 String sql = "insert into seance (date,horaire,nbPlaceMax,nbPlaceRestante,besoin,idSalle,idMat,num_ens)"
    		        + " values (?, ?, ?, ?, ?, ?, ?, ?)";
    	 
         PreparedStatement preparedStmt = connection.prepareStatement(sql);
         LocalDate data=datePickerSeance.getValue(); 
         preparedStmt.setDate(1, Date.valueOf(data)); 
         
         preparedStmt.setString (2, textHeure.getText());

         int nbplace = Integer.parseInt(textNbEtuMax.getText());
         preparedStmt.setInt (3, nbplace);
         preparedStmt.setInt (4, nbplace);
         
         preparedStmt.setString (5, textBesoin.getText());

         
         if(rbTp.isSelected()) {
             PreparedStatement statement2;
             statement2 = connection.prepareStatement("SELECT * FROM salle WHERE tp = 1");
             ResultSet resultSet2=  statement2.executeQuery();
             
             if(resultSet2.next()) {
            	 preparedStmt.setInt(6, resultSet2.getInt("idSalle")); }
             
         }else if (rbInfo.isSelected()) {
             PreparedStatement statement3;
             statement3 = connection.prepareStatement("SELECT * FROM salle WHERE info = 1");
             ResultSet resultSet3=  statement3.executeQuery();
             
             if(resultSet3.next()) {
            	 preparedStmt.setInt(6, resultSet3.getInt("idSalle")); }
         }else {
             PreparedStatement statement4;
             statement4 = connection.prepareStatement("SELECT * FROM salle WHERE info = 0 AND tp = 0");
             ResultSet resultSet4=  statement4.executeQuery(); 
             
             if(resultSet4.next()) {
            	 preparedStmt.setInt(6, resultSet4.getInt("idSalle")); }
         }
         
         
         int idmattt = Integer.parseInt(resultSet1.getString("idMat"));
         preparedStmt.setInt (7, idmattt);

         preparedStmt.setString (8, num_ens);
         
         preparedStmt.execute();
         
 		 Stage interfaceCS = (Stage) buttonCreerSeance.getScene().getWindow();
 		 interfaceCS.close();
 		 
 		Alert a = new Alert(AlertType.NONE, "Séance crée avec succès!"); 
 		a.setAlertType(AlertType.CONFIRMATION);
 		a.show();
         
         }
    	}catch(Exception e) {
    		erreur.setText("Erreur veuillez réessayer !");
    	}
         
         
		
         
    }

}

