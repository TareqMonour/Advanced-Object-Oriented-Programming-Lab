package com.example.class4;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ArrayListExample extends Application {
    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox(10);
        List<String> items = new ArrayList<>();
        items.add("Apple");
        items.add("Banana");
        items.add("Cherry");

        Iterator<String> iterator = items.iterator();

        ListView<String> listView = new ListView<>();
        while (iterator.hasNext()) {
            listView.getItems().add(iterator.next());
        }

        Button addButton = new Button("Add Item");
        addButton.setOnAction(e -> {
            String item;
            Scanner sc=new Scanner(System.in);
            item=sc.nextLine();
            items.add(item);
            listView.getItems().setAll(items);
        });

        root.getChildren().addAll(listView,addButton);

        Scene scene = new Scene(root, 300, 200);
        primaryStage.setTitle("ArrayList Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
