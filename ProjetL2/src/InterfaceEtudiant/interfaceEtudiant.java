package InterfaceEtudiant;

import DAO.EtudiantDAO;
import InterfaceConnexion.interfaceConnexionControleur;
import Modele.Etudiant;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

/**
 * class de l'interface étudiant
 */
public class interfaceEtudiant extends Application {

    public static Stage classStage;	
    /**
     * La méthode main est static et elle ne renvois rien.
     * Elle permet de lancer l'interface.
     *
     * @param args
     *          L'argument
     * @throws ClassNotFoundException
     * @throws SQLException
     */
	public static void main(String[] args)  {
        launch(args);

    }
    /**
     * La méthode start n'est pas static et elle ne retourne rien.
     * Elle permet de lancer l'interface Etudiant fxml en definissant le primaryStage
     *
     * @param primaryStage
     *          Le primaryStage
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    @Override
    public void start(Stage primaryStage) throws IOException{
    	
    	primaryStage.getIcons().add(new Image("favicon_univ.png"));
		
        Parent root = FXMLLoader.load(getClass().getResource("interfaceEtudiant.fxml"));
    	
        Scene scene = new Scene(root);
        
		

        primaryStage.setScene(scene);
        primaryStage.setTitle("Etudiant");
        primaryStage.show();

    }

    
}