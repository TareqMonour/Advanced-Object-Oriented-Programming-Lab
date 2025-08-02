module com.example.ct_2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ct_2 to javafx.fxml;
    exports com.example.ct_2;
}