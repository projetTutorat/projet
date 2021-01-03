package InterfaceEtudiant;

import DAO.EtudiantDAO;
import InterfaceConnexion.interfaceConnexionControleur;
import Modele.Etudiant;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;





public class interfaceEtudiant extends Application {

    public static Stage classStage;	

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws IOException, ClassNotFoundException, SQLException  {
    	
    	primaryStage.getIcons().add(new Image("favicon_univ.png"));
		
        Parent root = FXMLLoader.load(getClass().getResource("interfaceEtudiant.fxml"));
    	
        Scene scene = new Scene(root);
        
		

        primaryStage.setScene(scene);
        primaryStage.setTitle("Etudiant");
        primaryStage.show();

    }

    
}