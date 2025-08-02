package com.example.demo;


import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class DetailsController {

    @FXML
    private Text titleText;
    @FXML
    private Text descriptionText;
    @FXML
    private Text rentText;
    @FXML
    private Text roomDetailsText;
    @FXML
    private Text locationText;

    public void setProperty(Property property) {
        titleText.setText("Title: " + property.getTitle());
        descriptionText.setText("Description: " + property.getDescription());
        rentText.setText("Rent: " + property.getRent());
        roomDetailsText.setText("Room Details: " + property.getRoomDetails());
        locationText.setText("Location: " + property.getLocation());
    }
}
