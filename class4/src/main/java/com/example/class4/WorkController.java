package com.example.class4;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class WorkController{

    @FXML
    private TextField name;

    @FXML
    private TextField price;

    @FXML
    private Label result;

    @FXML
    private void checkout() throws IOException {
        Main.switchScene("result.fxml");

    }


}
