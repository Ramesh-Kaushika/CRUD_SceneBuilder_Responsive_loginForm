package com.example.projectone.controller;

import com.example.projectone.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    public AnchorPane root;
    @FXML
    private Label welcomeText;

    public HelloController() {
        System.out.println("Umba omn un aeheneam");
    }

    @FXML
    protected void onHelloButtonClick() {
       // welcomeText.setText("Welcome to JavaFX Application!");
        System.out.println("Ramesh");
    }

    public void btnNextOnAction(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) this.root.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("page-two.fxml"));

            Scene scene = new Scene(fxmlLoader.load());
            stage.setScene(scene);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}