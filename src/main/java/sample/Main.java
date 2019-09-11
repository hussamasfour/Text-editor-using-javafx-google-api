package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;

//Where it will get the reading from//gotta switch it to the controller
public class Main extends Application {

    Stage window;
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/sample.fxml"));
        //Icon Display
        primaryStage.setScene(new Scene(root, 900,400));       //Screen Size Display
        root.setStyle("-fx-background-color: #424242;");                    //Hbox Background Color Style
        primaryStage.show();


        //Title Display
        window = primaryStage;
        window.setTitle("NoteTaker");

        //Closing Window Display
        window.setOnCloseRequest(e -> {
            e.consume();
            closeProgram();
        });
    }
    private void closeProgram(){
        Boolean answer = ConfirmBox.display("NoteTaker ", "Are You Sure Want To Exit NoteTaker? " );
        if (answer)
            window.close();
    }

    public static void main(String[] args) throws IOException {
        launch(args);
    }
}