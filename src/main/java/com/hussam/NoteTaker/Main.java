package com.hussam.NoteTaker;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

//****IMPORTANT READ*****//
//The Email credentials That this program will upload to is:
//Email: csc330csi@gmail.com
//pw: GiveMeAPlease
//

//The program will create a pdf of what you wrote in the home directory, either with the default name or a given name.
//Then it will use that newly made pdf and upload it to google drive of the email that I have provided.

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