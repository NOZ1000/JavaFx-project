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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

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
        root  = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("SIpage.fxml")));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void clickMyProfile(ActionEvent event) throws IOException {
        root  = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("MyProfilepage.fxml")));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void clickAddPost(ActionEvent event) throws IOException {
        root  = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("AddPostspage.fxml")));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

//    public void postList() throws SQLException, ClassNotFoundException {
//        Button button = new Button();
//        button.setText("BUttonPost");
//        postBox.getChildren().add(button);
//
////        DatabaseHandler dbHandler = new DatabaseHandler();
////        ResultSet postResult = dbHandler.returnPosts();
////        int counter = 2;
////        String response = null;
////        try {
////            while (postResult.next()) {
////                response = postResult.getString(counter);
////
//////                System.out.println(postResult.getSQLXML(counter));
////                counter++;
////                System.out.println(response);
////            }
////        } catch (Exception e) {
////            System.out.println(e);
////        }
//
//    }

    @FXML
    void initialize() throws SQLException, ClassNotFoundException {
        printPosts();
    }

    public void printPosts() {
        DatabaseHandler dbHandler = new DatabaseHandler();

        try {
            for (int i = 1; i < dbHandler.countOfPosts() -1; i++) {
                ResultSet postResult = dbHandler.returnPosts(String.valueOf(i));
                postResult.next();
                String buttontext = "Post id: " + String.valueOf(i) + " | Title: " + postResult.getString("title");
                postBox.getChildren().add(new Button(buttontext));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
