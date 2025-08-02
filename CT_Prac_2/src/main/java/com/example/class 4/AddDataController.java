package com.example.class4;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AddDataController {
    @FXML
    private TextField idField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField emailField;
    @FXML
    private Label statusLabel;

    @FXML
    private TextField idField2;

    @FXML
    private Label statusLabel2;

    private static final String FILE_PATH = "records.txt";

    @FXML
    public void addRecord() {
        String id = idField.getText().trim();
        String name = nameField.getText().trim();
        String email = emailField.getText().trim();


        if (id.isEmpty() || name.isEmpty() || email.isEmpty()) {
            statusLabel.setText("All fields are required!");
            statusLabel.setStyle("-fx-text-fill: red;");
            return;
        }


        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(id + "," + name + "," + email);
            writer.newLine();
            statusLabel.setText("Record added successfully!");
            statusLabel.setStyle("-fx-text-fill: green;");


            idField.clear();
            nameField.clear();
            emailField.clear();
        } catch (IOException e) {
            statusLabel.setText("Error saving record: " + e.getMessage());
            statusLabel.setStyle("-fx-text-fill: red;");
        }
    }

    @FXML
    private void switchScene2() {
        try {
            HelloApplication.switchScene("scene1.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void deleteRecord() {
        String idToDelete = idField2.getText().trim();

        if (idToDelete.isEmpty()) {
            statusLabel.setText("ID is required!");
            statusLabel.setStyle("-fx-text-fill: red;");
            return;
        }

        List<String> updatedRecords = new ArrayList<>();
        boolean recordFound = false;

        // Read the file and remove the record with the matching ID
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length > 0 && parts[0].trim().equals(idToDelete)) {
                    recordFound = true;
                } else {
                    updatedRecords.add(line);
                }
            }
        } catch (IOException e) {
            statusLabel.setText("Error reading file: " + e.getMessage());
            statusLabel.setStyle("-fx-text-fill: red;");
            return;
        }

        if (!recordFound) {
            statusLabel.setText("Record not found!");
            statusLabel.setStyle("-fx-text-fill: red;");
            return;
        }

        // Write the updated records back to the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (String record : updatedRecords) {
                writer.write(record);
                writer.newLine();
            }
            statusLabel.setText("Record deleted successfully!");
            statusLabel.setStyle("-fx-text-fill: green;");
            idField2.clear();
        } catch (IOException e) {
            statusLabel.setText("Error writing to file: " + e.getMessage());
            statusLabel.setStyle("-fx-text-fill: red;");
        }
    }
}
