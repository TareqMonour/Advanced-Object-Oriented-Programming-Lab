package com.example.demo2;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.HashSet;
import java.util.Set;

public class HashSetExampleController {
    @FXML
    private TextField inputField;

    @FXML
    private ListView<String> listView;

    private final Set<String> items = new HashSet<>();

    @FXML
    public void initialize() {
        items.add("Red");
        items.add("Blue");
        items.add("Green");
        listView.getItems().addAll(items);
    }

    @FXML
    public void handleAddColor() {
        String color = inputField.getText().trim();
        if (!color.isEmpty()) {
            items.add(color);
            listView.getItems().setAll(items);
            inputField.clear();
        }
    }
}
