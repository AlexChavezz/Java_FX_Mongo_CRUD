package com.example.test;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminController {

    // Method to open the admin view
    public void start(Stage primaryStage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("admin-view.fxml"));
            Parent adminRoot = fxmlLoader.load();
            Scene scene = new Scene(adminRoot, 800, 400);
            primaryStage.setTitle("Admin View");
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
