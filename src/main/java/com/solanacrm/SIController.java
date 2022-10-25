package com.solanacrm;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SIController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField loginFieldSI;

    @FXML
    private PasswordField passFieldSI;

    @FXML
    private Label errorField;

    @FXML
    private Label successField;

    public void switchToSignUp(ActionEvent event) throws IOException {
        root  = FXMLLoader.load(getClass().getResource("SUpage.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToMainMenu(ActionEvent event) throws IOException {
        root  = FXMLLoader.load(getClass().getResource("Newspage.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private boolean SignInValidation(String login, String pass) throws SQLException, ClassNotFoundException {
        DatabaseHandler dbHandler = new DatabaseHandler();
        ResultSet UserResult = dbHandler.SIUser(loginFieldSI.getText(), passFieldSI.getText());
        ResultSet TeacherResult = dbHandler.SITeacher(loginFieldSI.getText(), passFieldSI.getText());

        int counter = 0;
        while (UserResult.next()) {
            counter++;
        }
        while (TeacherResult.next()) {
            counter++;
        }

        if (counter>=1) {
            System.out.println("Users exist");
            return true;
        } else {
            return false;
        }

    }
    public void submitSIButton(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        successField.setVisible(false);

        String login = loginFieldSI.getText().trim();
        String pass = passFieldSI.getText().trim();

        Auth.login = login;
        Auth.pass = pass;

        if (!login.equals("") && !pass.equals("")) {
            if (SignInValidation(login,pass)) {
                System.out.println("User Exist");
                switchToMainMenu(event);
            }
            else {
//                errorField.setText("Login or password is wrong!");
                errorField.setVisible(true);
            }
        }

    }

    @FXML
    void initialize() {
        if (Auth.SUSuccess) {
            successField.setVisible(true);
            Auth.SUSuccess = false;
        }

    }



}
