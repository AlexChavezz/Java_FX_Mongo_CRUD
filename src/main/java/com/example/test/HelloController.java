package com.example.test;


import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    public TextField userInput;
    public Label issueInput;

    @FXML
    protected void onHelloButtonClick() {
        String userToFind = userInput.getText();
        if (userToFind.isEmpty()) {
            issueInput.setText("You need to write something..");
            issueInput.setTextFill(Color.RED);
        } else {
            issueInput.setText("");
            Connection connection = new Connection();
            String response = connection.Connect(userToFind);
            welcomeText.setText(response);

            // Check the condition to open the admin view
            AdminController objeto = new AdminController();

            Stage stage = new Stage();
            objeto.start(stage);

            HelloApplication mainView = new HelloApplication();
            Stage primaryMainStage = mainView.getPrimaryStage();
            primaryMainStage.hide();

        }
    }
}