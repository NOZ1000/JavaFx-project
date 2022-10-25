package com.solanacrm;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;

public class HelloController {

    @FXML
    private TextField textField;

    @FXML
    private Label welcomeText;

    @FXML
    void onHelloButtonClick(ActionEvent event) {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    void onInputText(InputMethodEvent event) {

    }

    @FXML
    void onHelloButtonClick2(ActionEvent event) {
        welcomeText.setText(textField.getText());
    }


    @FXML
    void onClearButtonAction(ActionEvent event) {
        textField.clear();
    }

}



//    @FXML
//    protected void onHelloButtonClick() {
//        welcomeText.setText("Welcome to JavaFX Application!");
//    }


