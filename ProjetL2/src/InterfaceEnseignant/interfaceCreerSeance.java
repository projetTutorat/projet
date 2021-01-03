package InterfaceEnseignant;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class interfaceCreerSeance extends Application {

    public static Stage classStage;

    public static void main(String[] args) {
        launch(args);
    }

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
