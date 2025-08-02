module com.example.class_2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.class_2 to javafx.fxml;
    exports com.example.class_2;
}