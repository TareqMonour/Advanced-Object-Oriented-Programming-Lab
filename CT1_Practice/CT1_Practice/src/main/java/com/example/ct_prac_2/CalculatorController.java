package com.example.ct_prac_2;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class CalculatorController {

    @FXML
    private TextField n1;

    @FXML
    private TextField n2;

    @FXML
    private Label result;

    @FXML
    private void add(){
        result.setText(Integer.parseInt(n1.getText())+Integer.parseInt(n2.getText())+"");

    }
    @FXML
    private void sub(){
        result.setText(Integer.parseInt(n1.getText())-Integer.parseInt(n2.getText())+"");

    }

    @FXML
    private void mul(){
        result.setText(Integer.parseInt(n1.getText())*Integer.parseInt(n2.getText())+"");

    }
    @FXML
    private void div(){
        result.setText(Integer.parseInt(n1.getText())/Integer.parseInt(n2.getText())+"");

    }

    @FXML
    private void back() throws IOException {
        Main.switchScene("Result.fxml");
    }

}

