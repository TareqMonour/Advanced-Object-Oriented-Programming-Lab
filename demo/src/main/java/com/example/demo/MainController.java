package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainController {

    @FXML
    private ListView<String> listView;

    @FXML
    private Button detailsButton;

    private List<Property> properties = new ArrayList<>();

    public void initialize() {
        loadData();
        listView.getItems().setAll(getTitles());
        detailsButton.setDisable(true);
        
        listView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            detailsButton.setDisable(newValue == null);
        });
    }

    private void loadData() {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/com/example/demo/tolets.txt"))) {
            String line;
            Property currentProperty = null;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Title:")) {
                    if (currentProperty != null) properties.add(currentProperty);
                    currentProperty = new Property();
                    currentProperty.setTitle(line.substring(7).trim());
                } else if (line.startsWith("Description:") && currentProperty != null) {
                    currentProperty.setDescription(line.substring(12).trim());
                } else if (line.startsWith("Rent:") && currentProperty != null) {
                    currentProperty.setRent(line.substring(5).trim());
                } else if (line.startsWith("Room Details:") && currentProperty != null) {
                    currentProperty.setRoomDetails(line.substring(13).trim());
                } else if (line.startsWith("Location:") && currentProperty != null) {
                    currentProperty.setLocation(line.substring(9).trim());
                }
            }
            if (currentProperty != null) properties.add(currentProperty);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<String> getTitles() {
        List<String> titles = new ArrayList<>();
        for (Property p : properties) {
            titles.add(p.getTitle());
        }
        return titles;
    }

    @FXML
    private void handleDetailsClick() {
        String selectedTitle = listView.getSelectionModel().getSelectedItem();
        Property selectedProperty = null;

        for (Property p : properties) {
            if (p.getTitle().equals(selectedTitle)) {
                selectedProperty = p;
                break;
            }
        }

        if (selectedProperty != null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("details.fxml"));
                Parent root = loader.load();
                DetailsController detailsController = loader.getController();
                detailsController.setProperty(selectedProperty);

                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setTitle("Property Details");
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
                showError("Failed to load details.");
            }
        }
    }

    private void showError(String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
