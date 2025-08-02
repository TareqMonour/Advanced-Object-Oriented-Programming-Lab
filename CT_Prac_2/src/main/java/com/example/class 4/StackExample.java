package com.example.class4;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Stack;

public class StackExample extends Application {
    @Override
    public void start(Stage primaryStage) {
        Stack<String> stack = new Stack<>();
        ListView<String> listView = new ListView<>();

        Button pushButton = new Button("Push Item");
        pushButton.setOnAction(e -> {
            stack.push("Item " + (stack.size() + 1));
            listView.getItems().setAll(stack);
        });

        Button popButton = new Button("Pop Item");
        popButton.setOnAction(e -> {
            if (!stack.isEmpty()) {
                stack.pop();
                listView.getItems().setAll(stack);
            }
        });

        VBox root = new VBox(10, pushButton, popButton, listView);
        Scene scene = new Scene(root, 300, 200);
        primaryStage.setTitle("Stack Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

