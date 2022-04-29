module com.example.biblioteca {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;


    opens com.example.biblioteca to javafx.fxml;
    exports com.example.biblioteca;
}