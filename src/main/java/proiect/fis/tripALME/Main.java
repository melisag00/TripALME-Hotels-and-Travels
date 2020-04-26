package proiect.fis.tripALME;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main (String [] args){
        launch(args);
    }


    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("simple.fxml"));
        primaryStage.setTitle("Registration");
        primaryStage.setScene(new Scene(root, 500, 500));
        primaryStage.show();
    }
}






