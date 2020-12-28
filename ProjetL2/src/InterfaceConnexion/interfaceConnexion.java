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
    	// On ex�cute l'interface
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
    	
    	// On associe l'interface interfaceConnexion � son interface FXML
        Parent root = FXMLLoader.load(getClass().getResource("InterfaceConnexion.fxml"));

        // On cr�e une nouvelle sc�ne et on lance la fen�tre
        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Connexion");
        primaryStage.show();

    }


}
