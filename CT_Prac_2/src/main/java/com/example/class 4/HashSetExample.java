package com.example.class4;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.HashSet;
import java.util.Set;

public class HashSetExample extends Application {
    @Override
    public void start(Stage primaryStage) {
        Set<String> items = new HashSet<>();
        items.add("Red");
        items.add("Blue");
        items.add("Green");

        ListView<String> listView = new ListView<>();
        listView.getItems().addAll(items);

        TextField input = new TextField();
        input.setPromptText("Enter color");
        input.setOnAction(e -> {
            items.add(input.getText());
            listView.getItems().setAll(items);
            input.clear();
        });

        VBox root = new VBox(10, input, listView);
        Scene scene = new Scene(root, 300, 200);
        primaryStage.setTitle("HashSet Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

