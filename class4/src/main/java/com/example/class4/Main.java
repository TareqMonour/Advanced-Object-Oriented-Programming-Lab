package com.example.class4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    private static Stage primaryStage;
    @Override
    public void start(Stage stage) throws IOException {
        Parent root =  FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(root, 600, 400);

        primaryStage = stage;

        stage.setTitle("Student Portal");
        stage.setScene(scene);
        stage.show();
    }

    public static void switchScene(String fxml)throws IOException{
        Parent root1 = FXMLLoader.load(Main.class.getResource(fxml));
        primaryStage.setScene(new Scene(root1,600,400));
    }

    public static void main(String[] args) {
        launch();
    }
}