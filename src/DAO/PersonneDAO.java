package DAO;

import Modele.Personne;
import javafx.scene.control.TextField;

import java.sql.*;

public class PersonneDAO extends DAO<Personne> {
    @Override
    public Personne find(String id) {
        Personne personne = new Personne();
        ResultSet result = null;
        try {
            result = this.connect
                    .createStatement(
                            ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_UPDATABLE
                    ).executeQuery(
                            "SELECT * FROM Personne WHERE id = " + id
                    );
                /*
                while(result.next()) {
                    String nom = result.getString(1);
                    String prenom = result.getString(2);
                    String date_de_naissance = result.getString(3);
                    String numero_identification = result.getString(4);
                    String mot_de_passe = result.getString(5);
                    String email= result.getString(6);
                    String numero_telephone= result.getString(7);
                }
            */

                if (result.first()){
                    personne = new Personne(
                            //id,
                            result.getString(1),
                            result.getString(2),
                            result.getString(3),
                            result.getString(4),
                            result.getString(5),
                            result.getString(6),
                            result.getString(7)


                    );

                }
        }catch (SQLException e) {
                e.printStackTrace();
            }
            return personne;
    }

    @Override
    public Personne create(Personne personne) {
        try {
            ResultSet result = this    .connect
                    .createStatement(
                            ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_UPDATABLE
                    ).executeQuery(
                            "SELECT NEXTVAL('langage_lan_id_seq') as id"
                    );
            if(result.first()){
                long id = result.getLong("id");
                PreparedStatement prepare = this    .connect
                        .prepareStatement(
                                "INSERT INTO langage (lan_id, lan_nom) VALUES(?, ?)"
                        );
                prepare.setLong(1, id);
                prepare.setString(2, personne.getNom());
/*
                prepare.executeUpdate();
                personne = this.find(id);
*/
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return personne;
    }

    @Override
    public Personne update(Personne personne) {
        try {

            this .connect
                    .createStatement(
                            ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_UPDATABLE
                    ).executeUpdate(
                    "UPDATE langage SET lan_nom = '" + personne.getNom() + "'"+
                            " WHERE lan_id = " + personne.getNumero_identification()
            );

            personne = this.find(personne.getNumero_identification());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return personne;
    }

    @Override
    public void delete(Personne personne) {
        try {

            this    .connect
                    .createStatement(
                            ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_UPDATABLE
                    ).executeUpdate(
                    "DELETE FROM langage WHERE lan_id = " + personne.getNumero_identification()
            );

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }







    public void connect_prof(TextField textId, TextField textMdp) throws ClassNotFoundException, SQLException {

        String url = "jdbc:mysql://localhost/projet+l2";
        String login = "root";
        String password = "";

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, login, password);

        Statement stmt = con.createStatement();

        String sql = "SELECT mdp FROM etudiant WHERE num_etu ='"+textId.getText()+"'";
        ResultSet rs = stmt.executeQuery(sql);

        if (rs.next()) {
            if (textMdp.getText().equals(rs.getString(1))) {
                System.out.println("Connexion réussi");
            }else {
                System.out.println("Mot de passe incorrect");
            }
        }else {
            System.out.println("Identifiant inexistant");
        }


    }
}
