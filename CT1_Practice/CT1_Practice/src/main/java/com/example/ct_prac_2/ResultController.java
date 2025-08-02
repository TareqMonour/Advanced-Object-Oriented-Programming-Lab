package com.example.ct_prac_2;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

public class ResultController {

    @FXML
    private Label resultLabel;

    @FXML
    public void initialize(){
        resultLabel.setText("Welcome Student");
    }


        @FXML
    private void result() throws IOException {
        Main.switchScene("Calculate.fxml");

    }

    @FXML
    private void calculator() throws IOException {
        Main.switchScene("Calculator.fxml");

    }
}
