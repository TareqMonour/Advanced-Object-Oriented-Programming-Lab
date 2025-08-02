package com.example.demo;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ToLetSearchAppV2 extends Application {

    private ObservableList<String> data = FXCollections.observableArrayList();
    private String loggedInUsername = "user1"; // Replace with actual logged-in username logic

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // UI Components
        TextField searchField = new TextField();
        searchField.setPromptText("Enter location to search");

        Button searchButton = new Button("Search");

        ListView<String> resultListView = new ListView<>();
        resultListView.setItems(data);

        Button deleteButton = new Button("Delete Selected Post");
        deleteButton.setDisable(true);

        // Load initial data
        List<String> allEntries = loadDataFromFile("src/main/resources/com/example/demo/tolets.txt");

        // Search Button Action
        searchButton.setOnAction(e -> {
            String location = searchField.getText().trim().toLowerCase();
            filterResults(location, allEntries);
        });

        // Enable delete button only if the logged-in user is the post owner
        resultListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            deleteButton.setDisable(newValue == null || !newValue.contains("Username: " + loggedInUsername));
        });

        // Delete Button Action
        deleteButton.setOnAction(e -> {
            String selectedPost = resultListView.getSelectionModel().getSelectedItem();
            if (selectedPost != null) {
                allEntries.remove(selectedPost);
                data.remove(selectedPost);
                saveDataToFile("src/main/resources/com/example/demo/tolets.txt", allEntries);
                showAlert("Success", "Post deleted successfully.");
            }
        });

        // Layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));

        HBox controls = new HBox(10);
        controls.getChildren().addAll(searchField, searchButton);

        layout.getChildren().addAll(controls, resultListView, deleteButton);

        // Scene and Stage
        Scene scene = new Scene(layout, 500, 500);
        primaryStage.setTitle("ToLet Search Application");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private List<String> loadDataFromFile(String fileName) {
        List<String> entries = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder entry = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    entries.add(entry.toString().trim());
                    entry.setLength(0);
                } else {
                    entry.append(line).append("\n");
                }
            }
            if (!entry.isEmpty()) {
                entries.add(entry.toString().trim());
            }
        } catch (IOException e) {
            showAlert("Error", "Unable to load data from file.");
        }
        return entries;
    }

    private void saveDataToFile(String fileName, List<String> entries) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String entry : entries) {
                writer.write(entry);
                writer.write("\n\n");
            }
        } catch (IOException e) {
            showAlert("Error", "Unable to save data to file.");
        }
    }

    private void filterResults(String location, List<String> allEntries) {
        if (location.isEmpty()) {
            showAlert("Warning", "Location field cannot be empty.");
            return;
        }

        List<String> filteredData = allEntries.stream()
                .filter(entry -> entry.toLowerCase().contains("location: " + location))
                .collect(Collectors.toList());

        data.setAll(filteredData);

        if (filteredData.isEmpty()) {
            showAlert("Info", "No results found for the given location.");
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
