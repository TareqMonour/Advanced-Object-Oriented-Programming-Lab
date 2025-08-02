package com.example.ct_prac_2;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;

public class LoginController {

    @FXML
    private TextField txtUsername;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private Label lblerror;

    @FXML
    private void handleLogin() {

        try {
            BufferedReader reader = new BufferedReader(new FileReader("login.txt"));
            String line ;
            while ((line = reader.readLine())!=null){
                String [] parts = line.split(",");

                if(txtUsername.getText().equals(parts[0]) && txtPassword.getText().equals(parts[1])) {
                    try {
                        Main.switchScene("Result.fxml");
                        break;
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                else {
                    lblerror.setText("Username or Password isn’t correct.");
                    txtUsername.clear();
                    txtPassword.clear();
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }




    }

}
