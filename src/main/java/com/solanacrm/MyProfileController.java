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
import java.util.Objects;

public class MyProfileController extends NewsController {
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
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Newspage.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
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
                        new PieChart.Data("JS", 8),
                        new PieChart.Data("C++", 22),
                        new PieChart.Data("JAVA", 10),
                        new PieChart.Data("PHP", 30),
                        new PieChart.Data("Python", 30));


        pieChart.setData(pieChartData);
    }

}
