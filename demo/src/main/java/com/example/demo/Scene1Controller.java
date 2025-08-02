package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class Scene1Controller {
    public Circle circle1;
    public Circle circle2;
    public Rectangle rectangle1;

    public void leftButton() {
       circle1.setLayoutX(circle1.getLayoutX() - 10);
       circle2.setLayoutX(circle2.getLayoutX() - 10);
       rectangle1.setLayoutX(rectangle1.getLayoutX() - 10);
    }

    public void rightButton() {
        circle1.setLayoutX(circle1.getLayoutX() + 10);
        circle2.setLayoutX(circle2.getLayoutX() + 10);
        rectangle1.setLayoutX(rectangle1.getLayoutX() + 10);
    }

    public void upButton() {
        circle1.setLayoutY(circle1.getLayoutY() - 10);
        circle2.setLayoutY(circle2.getLayoutY() - 10);
        rectangle1.setLayoutY(rectangle1.getLayoutY() - 10);
    }

    public void downButton() {
        circle1.setLayoutY(circle1.getLayoutY() + 10);
        circle2.setLayoutY(circle2.getLayoutY() + 10);
        rectangle1.setLayoutY(rectangle1.getLayoutY() + 10);
    }

    public void scene2(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("scene2.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene =new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}