package com.example.ct_2;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class CartController {
    public TextField NameFiled;
    public TextField PriceField;
    public TextArea ShowField;
    public TextField TotalField;

    ArrayList<Item> items = new ArrayList<>();
    static double total = 0;

    public void CheckoutButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(CheckoutController.class.getResource("checkout.fxml"));
        Parent parent = loader.load();
        Stage stage = new Stage();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
        CheckoutController c = new CheckoutController();
        c.TotalField.setText(String.valueOf(total));
    }

    public void AddButton(ActionEvent actionEvent) {
        if (!NameFiled.getText().isBlank() && !PriceField.getText().isBlank()){
            String name = NameFiled.getText();
            double price = Double.parseDouble(PriceField.getText());
            items.add(new Item(name,price));
            total = Double.parseDouble(TotalField.getText()) + price;
            TotalField.setText(String.valueOf(total));
            StringBuilder list = new StringBuilder();
            for (Item i : items) {
                list.append(i.name).append(" = ").append(i.price).append("\n");
            }
            ShowField.setText(list.toString());
//            nameField.clear();
        }

    }
}
