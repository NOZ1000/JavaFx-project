package com.solanacrm;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class MyProfileController extends NewsController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Label firstName;

    @FXML
    private Label lastName;

    @FXML
    private Label login;

    @FXML
    private Label pass;

    @FXML
    private PieChart pieChart;

    public void clickNews(ActionEvent event) throws IOException {
        root  = FXMLLoader.load(getClass().getResource("Newspage.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void initialize() {
        login.setText(Auth.login);
        pass.setText(Auth.pass);
        firstName.setText("Zubenko");
        lastName.setText("Michail");

        drawChart();

    }

    public void drawChart() {
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("JS", 13),
                        new PieChart.Data("C++", 22),
                        new PieChart.Data("JAVA", 10),
                        new PieChart.Data("PHP", 25),
                        new PieChart.Data("Python", 30));


        pieChart.setData(pieChartData);
    }

}
