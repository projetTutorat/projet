package DAO;

import Modele.Seance;
import java.sql.*;


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


    public Seance creerSeance(Seance seance,int idMat,String num_ens) {
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
            statement.setInt(6,idMat);
            statement.setString(7,num_ens);


            statement.execute();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seance;
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



    public void supprimerSeance(){

    }



    public Seance afficherSeanceDisponible(String num_etu){
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



            Seance seance= new Seance();
            while(resultSet.next()) {
                PreparedStatement statement2 = connection.prepareStatement("SELECT * FROM salle WHERE idSalle=?");
                statement2.setString(1,resultSet.getString(7));
                ResultSet resultSet2=  statement2.executeQuery();
                if(resultSet2.next()) {
                    PreparedStatement statement3 = connection.prepareStatement("SELECT * FROM matiere WHERE idMat=?");
                    statement3.setString(1,resultSet.getString(8));
                    ResultSet resultSet3=  statement3.executeQuery();
                    if(resultSet3.next()) {
                        PreparedStatement statement4 = connection.prepareStatement("SELECT * FROM enseignant WHERE num_ens=?");
                        statement4.setString(1,resultSet.getString(9));
                        ResultSet resultSet4=  statement4.executeQuery();
                        if(resultSet4.next()) {
                            PreparedStatement statement5 = connection.prepareStatement("SELECT * FROM participe_etudiant_seance WHERE num_etu=?");
                            statement5.setString(1,num_etu);
                            ResultSet resultSet5=statement5.executeQuery();
                            if(resultSet5.next()) {
                                if(!resultSet.getString(1).equals(resultSet5.getString(1))) {
                                    System.out.println("Tutorat le "+resultSet.getString(2)+" à  "+resultSet.getString(3)+" | "+resultSet.getString(6)+" Salle:"+
                                            resultSet2.getString(2)+resultSet2.getString(3)+resultSet2.getString(4)+resultSet2.getString(5)+
                                            " Matière: "+resultSet3.getString(2)+resultSet3.getString(3)+" Professeur: "+resultSet4.getString(2)+resultSet4.getString(3));
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
                statement2.setString(1,resultSet.getString(7));
                ResultSet resultSet2=  statement2.executeQuery();
                if(resultSet2.next()) {
                    PreparedStatement statement3 = connection.prepareStatement("SELECT * FROM matiere WHERE idMat=?");
                    statement3.setString(1,resultSet.getString(8));
                    ResultSet resultSet3=  statement3.executeQuery();
                    if(resultSet3.next()) {
                        PreparedStatement statement4 = connection.prepareStatement("SELECT * FROM enseignant WHERE num_ens=?");
                        statement4.setString(1,resultSet.getString(9));
                        ResultSet resultSet4=  statement4.executeQuery();
                        if(resultSet4.next()) {
                            PreparedStatement statement5 = connection.prepareStatement("SELECT * FROM participe_etudiant_seance WHERE num_etu=?");
                            statement5.setString(1,num_etu);
                            ResultSet resultSet5=statement5.executeQuery();
                            if(resultSet5.next()) {
                                if(resultSet5.getString(1).equals(resultSet.getString(1))) {
                                    System.out.println("Tutorat le "+resultSet.getString(2)+" à  "+resultSet.getString(3)+" | "+resultSet.getString(6)+" Salle:"+
                                            resultSet2.getString(2)+resultSet2.getString(3)+resultSet2.getString(4)+resultSet2.getString(5)+
                                            " Matière: "+resultSet3.getString(2)+resultSet3.getString(3)+" Professeur: "+resultSet4.getString(2)+resultSet4.getString(3));

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



    public Seance ajouterSalleASeance(){
        return null;
    }

    public Seance afficheMesTutoratsEnseignant(String num_ens) {
        try {
            Connection connection = ConnexionBDD.getInstance();
            PreparedStatement statement;
            statement = connection.prepareStatement("SELECT * FROM seance S WHERE num_ens=?");

            statement.setString(1,num_ens);
            ResultSet resultSet=  statement.executeQuery();

            Seance seance= new Seance();

            while(resultSet.next()) {
                PreparedStatement statement2 = connection.prepareStatement("SELECT * FROM salle WHERE idSalle=?");
                statement2.setString(1,resultSet.getString(7));
                ResultSet resultSet2=  statement2.executeQuery();
                if(resultSet2.next()) {
                    PreparedStatement statement3 = connection.prepareStatement("SELECT * FROM matiere WHERE idMat=?");
                    statement3.setString(1,resultSet.getString(8));
                    ResultSet resultSet3=  statement3.executeQuery();
                    if(resultSet3.next()) {
                        PreparedStatement statement4 = connection.prepareStatement("SELECT * FROM enseignant WHERE num_ens=?");
                        statement4.setString(1,resultSet.getString(9));
                        ResultSet resultSet4=  statement4.executeQuery();
                        if(resultSet4.next()) {
                            System.out.println("Tutorat le "+resultSet.getString(2)+" à  "+resultSet.getString(3)+" | "+resultSet.getString(6)+" Salle:"+
                                    resultSet2.getString(2)+resultSet2.getString(3)+resultSet2.getString(4)+resultSet2.getString(5)+
                                    " Matière: "+resultSet3.getString(2)+resultSet3.getString(3)+" Professeur: "+resultSet4.getString(2)
                                    +resultSet4.getString(3));
                            PreparedStatement statement5 = connection.prepareStatement("SELECT * FROM etudiant e INNER JOIN participe_etudiant_seance p ON e.num_etu = p.num_etu INNER JOIN seance s ON p.idSeance = s.idSeance WHERE s.idSeance = ? AND s.num_ens = ?");
                            statement5.setString(1,resultSet.getString(1));
                            statement5.setString(2,num_ens);

                            ResultSet resultSet5=statement5.executeQuery();
                            while(resultSet5.next()) {
                                System.out.println(resultSet5.getString(1)+" "+resultSet5.getString(3)+resultSet5.getString(2));
                                
                            }
                            System.out.println();
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


}

