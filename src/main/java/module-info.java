module com.example.projectone {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.projectone to javafx.fxml;
    exports com.example.projectone;
    exports com.example.projectone.controller;
    opens com.example.projectone.controller to javafx.fxml;
    opens com.example.projectone.tm;
}

