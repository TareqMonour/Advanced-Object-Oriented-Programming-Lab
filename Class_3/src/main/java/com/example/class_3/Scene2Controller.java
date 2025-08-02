package com.example.class_3;

import javafx.fxml.FXML;

public class Scene2Controller {
    @FXML
    private void switchScene1(){
        try{
            MainApplication.switchScene("scene1.fxml");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
