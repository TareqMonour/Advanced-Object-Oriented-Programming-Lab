package com.example.ct_2;

import javafx.scene.control.Label;

public class CheckoutController {
    public  Label TotalField;
    double total = CartController.total;
    public void ShowTotal(){
        TotalField.setText(String.valueOf(total));
    }
}
