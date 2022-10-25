package com.solanacrm;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


import java.io.IOException;

public class NewsController {
    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    public ProgressIndicator fakeLoad;

    @FXML
    private VBox postBox;



    @FXML
    public void clickLoading(MouseEvent event) {
        Double value;
        if (fakeLoad.getOpacity() == 1) {
            value = 0.0;
        } else {
            value = 1.0;
        }
        fakeLoad.setOpacity(value);
    }

    @FXML
    public void clickLogOut(ActionEvent event) throws IOException {
        root  = FXMLLoader.load(getClass().getResource("SIpage.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void clickMyProfile(ActionEvent event) throws IOException {
        root  = FXMLLoader.load(getClass().getResource("MyProfilepage.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void postList() {
        Button button = new Button();
        button.setText("BUttonPost");
        postBox.getChildren().add(button);
    }

    @FXML
    void initialize() {
        postList();
    }
}
