package com.solanacrm;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class PostsController extends NewsController {

    @FXML
    private Label postTitle;

    @FXML
    private TextArea postContent;

    @FXML
    private TextArea postContentAdd;

    @FXML
    private TextArea postTitleAdd;

    @FXML
    private Label successfullyAdded;



    @FXML
    public void clickSendPost(ActionEvent event) throws SQLException, ClassNotFoundException {
        DatabaseHandler dbHandler = new DatabaseHandler();
        dbHandler.AddPost(postTitleAdd.getText(), postContentAdd.getText());
        successfullyAdded.setVisible(true);
    }


    @FXML
    public void clickNews(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Newspage.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void fillPostContent() {

    }

    @FXML
    void initialize() {

    }

}
