package com.example.class_3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

import static javafx.application.Application.launch;

public class MainApplication extends Application {

    private static Stage primaryStage;

    public void start(Stage stage) throws IOException{
        FXMLLoader fxmlLoader=new FXMLLoader(MainApplication.class.getResource("scene1.fxml"));

        primaryStage=stage;

        Scene scene=new Scene(fxmlLoader.load() ,600,400);
        stage.setTitle("Class 3");
        stage.setScene(scene);
        stage.show();
    }

    public static void switchScene(String fxmlFile) throws Exception{
        Parent root= FXMLLoader.load(Objects.requireNonNull(MainApplication.class.getResource(fxmlFile)));
        primaryStage.setScene(new Scene(root));
    }

    public static void main(String[] args) {
        launch();
    }


}
