package com.example.ct_prac_2;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class CalculateController {
    @FXML
    private Label pass;
    @FXML
    private Label fail;
    @FXML
    private TextField quiz;
    @FXML
    private TextField mid;
    @FXML
    private TextField fnal;

    @FXML
    private void calculate(){
        pass.setText("");
        fail.setText("");
        try{
            if(Double.parseDouble(quiz.getText().trim())+Double.parseDouble(mid.getText().trim())+Double.parseDouble(fnal.getText().trim()) >=60){
                pass.setText("You are passed");
                quiz.clear();
                mid.clear();
                fnal.clear();
            }
            else {
                fail.setText("You are Failed");
                quiz.clear();
                mid.clear();
                fnal.clear();
            }

        }catch (Exception e){

        }
    }
    @FXML
    private void back() throws IOException {
        Main.switchScene("Result.fxml");
    }
}
