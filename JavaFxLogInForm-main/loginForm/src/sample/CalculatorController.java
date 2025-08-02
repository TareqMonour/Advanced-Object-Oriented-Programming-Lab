package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class CalculatorController {

    @FXML
    private TextField display;

    private double firstOperand = 0;
    private String operator = "";
    private boolean isOperatorPressed = false;

    @FXML
    public void processNumber(ActionEvent event) {
        String value = ((Button) event.getSource()).getText();
        if (isOperatorPressed) {
            display.clear();
            isOperatorPressed = false;
        }
        display.appendText(value);
    }

    @FXML
    public void processOperator(ActionEvent event) {
        String value = ((Button) event.getSource()).getText();
        if (!value.equals("=")) {
            operator = value;
            firstOperand = Double.parseDouble(display.getText());
            isOperatorPressed = true;
        }
    }

    @FXML
    public void calculateResult(ActionEvent event) {
        try {
            double secondOperand = Double.parseDouble(display.getText());
            double result = 0;

            switch (operator) {
                case "+" -> result = firstOperand + secondOperand;
                case "-" -> result = firstOperand - secondOperand;
                case "*" -> result = firstOperand * secondOperand;
                case "/" -> result = firstOperand / secondOperand;
            }

            display.setText(String.valueOf(result));
            operator = "";
            isOperatorPressed = false;
        } catch (NumberFormatException e) {
            display.setText("Error");
        }
    }

    @FXML
    public void clearDisplay(ActionEvent event) {
        display.clear();
        firstOperand = 0;
        operator = "";
    }

    @FXML
    public void goBack(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("afterlogin.fxml");
    }
}
