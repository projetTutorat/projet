package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionBDD{

    /**
     * URL de connexion
     */
    private static String url = "jdbc:mysql://localhost/projet?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    /**
     * Nom du user
     */
    private static String user = "root";
    /**
     * Mot de passe du user
     */
    private static String passwd = "";
    /**
     * Objet Connexion
     */
    private static Connection connect;

    /**
     * Méthode qui va nous retourner notre instance
     * et la créer si elle n'existe pas...
     * @return
     */
    
    public static Connection getInstance(){
        if(connect == null){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connect = DriverManager.getConnection(url, user, passwd);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return connect;
    }
}
