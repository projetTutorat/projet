package InterfaceConnexion;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import DAO.PersonneDAO;

public class interfaceConnexion extends Application {

    public static void main(String[] args) {
    	// On exécute l'interface
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
    	
    	// On associe l'interface interfaceConnexion à son interface FXML
        Parent root = FXMLLoader.load(getClass().getResource("InterfaceConnexion.fxml"));

        // On crée une nouvelle scène et on lance la fenêtre
        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Connexion");
        primaryStage.show();

    }


}
