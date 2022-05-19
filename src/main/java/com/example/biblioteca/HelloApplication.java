package com.example.biblioteca;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("loading.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1050, 600);
        stage.setTitle("Biblioteca-Loading");
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }


    public static void main(String[] args){
        launch();
    }
}