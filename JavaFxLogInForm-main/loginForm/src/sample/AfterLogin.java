package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AfterLogin {

    @FXML
    private Button logout;

    @FXML
    private TextField amountField;

    @FXML
    private ComboBox<String> fromCurrency;

    @FXML
    private ComboBox<String> toCurrency;

    @FXML
    private Label resultLabel;

    private final Map<String, Double> exchangeRates = new HashMap<>();

    public void initialize() {
        // Initialize currency options and exchange rates
        fromCurrency.getItems().addAll("USD", "EUR", "BDT", "INR");
        toCurrency.getItems().addAll("USD", "EUR", "BDT", "INR");

        // Define some sample exchange rates
        exchangeRates.put("USD-EUR", 0.92);
        exchangeRates.put("USD-BDT", 120.0);
        exchangeRates.put("USD-INR", 82.70);

        exchangeRates.put("EUR-USD", 1.09);
        exchangeRates.put("EUR-BDT", 125.0);
        exchangeRates.put("EUR-INR", 90.00);

        exchangeRates.put("BDT-USD", 0.0084);
        exchangeRates.put("BDT-EUR", 0.0080);
        exchangeRates.put("BDT-INR", 0.71);

        exchangeRates.put("INR-USD", 0.012);
        exchangeRates.put("INR-EUR", 0.011);
        exchangeRates.put("INR-BDT", 1.41);
    }

    public void userLogOut(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("sample.fxml");
    }

    @FXML
    public void convertCurrency(ActionEvent event) {
        try {
            double amount = Double.parseDouble(amountField.getText());
            String from = fromCurrency.getValue();
            String to = toCurrency.getValue();

            if (from == null || to == null) {
                resultLabel.setText("Please Select Currencies.");
                return;
            }

            String key = from + "-" + to;
            if (!exchangeRates.containsKey(key)) {
                resultLabel.setText("Exchange Rate not Available.");
                return;
            }

            double rate = exchangeRates.get(key);
            double result = amount * rate;

            resultLabel.setText(String.format("%.2f %s", result, to));
        } catch (NumberFormatException e) {
            resultLabel.setText("Invalid Amount.");
        }
    }
}