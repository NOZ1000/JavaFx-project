package com.solanacrm;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class SUController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    //SU elements
    @FXML
    private PasswordField confirmPassFieldSU;

    @FXML
    private TextField firstNameFieldSU;

    @FXML
    private TextField lastNameFieldSU;

    @FXML
    private TextField loginFieldSU;

    @FXML
    private PasswordField passFieldSU;

    @FXML
    private RadioButton imTeacher;

    @FXML
    private Label errorField;


    public void switchToSignIn(ActionEvent event) throws IOException {
        root  = FXMLLoader.load(getClass().getResource("SIpage.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void submitSUButton(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        DatabaseHandler dbHandler = new DatabaseHandler();
        boolean sqlErrors = false;

        if(!imTeacher.isSelected()) {
            try {
                dbHandler.SUUser(firstNameFieldSU.getText(), lastNameFieldSU.getText(), loginFieldSU.getText(), passFieldSU.getText());
            } catch (SQLIntegrityConstraintViolationException e) {
                sqlErrors = true;
                errorField.setVisible(true);
            }
        } else {
            try {
                dbHandler.SUTeacher(firstNameFieldSU.getText(), lastNameFieldSU.getText(), loginFieldSU.getText(), passFieldSU.getText());
            } catch (SQLIntegrityConstraintViolationException e) {
                sqlErrors = true;
                errorField.setVisible(true);
            }
        }
        if(!sqlErrors) {
            Auth.SUSuccess = true;
            switchToSignIn(event);

        }
    }
}
