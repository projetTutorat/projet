package InterfaceEnseignant;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * Class de l'interface pour créer une séance
 */
public class interfaceCreerSeance extends Application  {

    public static Stage classStage;

	 /**
	    * La méthode main est static et ne retourne rien.
	    * Elle éxécute l'interface.
	    *
	    * @param args
	    *          L'argument
	    */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * La méthode start n'est pas static et elle ne retourne rien.
     * Elle permet de lancer l'interfaceCreerSeance en fxml en definissant le primaryStage
     *
     * @param primaryStage
     *          Le primaryStage
     * @throws IOException
     */
    @Override
    public void start(Stage primaryStage) throws IOException {
    	

    	primaryStage.getIcons().add(new Image("favicon_univ.png"));
    	
        Parent root = FXMLLoader.load(getClass().getResource("interfaceCreerSeance.fxml"));

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Test formulaire");
        primaryStage.show();
    }
}
