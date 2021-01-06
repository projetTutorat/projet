package InterfaceEnseignant;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
/**
 * class interface enseignant
 */
public class interfaceEnseignant extends Application {

    public static Stage classStage;
    /**
     * La méthode main est static et ne retourne rien.
     * Elle permet de lancer l'interface.
     *
     * @param args
     *          L'argument
     */
    public static void main(String[] args) {
        launch(args);
    }
    /**
     * La méthode start n'est pas static et elle ne retourne rien.
     * Elle permet de lancer l'interface fxml en définissant le primaryStage.
     *
     * @param primaryStage
     *          Le primaryStage
     * @throws IOException
     */
    @Override
    public void start(Stage primaryStage) throws IOException {
    	
    	primaryStage.getIcons().add(new Image("favicon_univ.png"));
    	
        Parent root = FXMLLoader.load(getClass().getResource("interfaceEnseignant.fxml"));

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Test enseignant");
        primaryStage.show();
    }
}
