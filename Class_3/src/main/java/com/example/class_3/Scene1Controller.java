package com.example.class_3;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Scene1Controller {
    @FXML
    TextField nameInput;

    @FXML
    Label nameLabel;

    @FXML
    protected void clickMe() {
        nameLabel.setText("Name Inputted");
        System.out.println(nameInput.getText());

    }

    @FXML
    private void switchScene2(){
        try{
            MainApplication.switchScene("scene2.fxml");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
