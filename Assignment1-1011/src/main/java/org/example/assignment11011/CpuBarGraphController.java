package org.example.assignment11011;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CpuBarGraphController implements Initializable{
    @FXML
    private NumberAxis CPUNumberAxis;

    @FXML
    private CategoryAxis CPUcategoryAxis;

    @FXML
    private BarChart<String, Double> chartCPU;

    @FXML
    private CheckBox checkCPU;

    @FXML
    private CheckBox checkCooler;

    @FXML
    private CheckBox checkGPU;

    @FXML
    private AnchorPane mainPane;
    @FXML
    private Button checkHardware;


    // Method to handle CPU checkbox action
    @FXML
    private void handleCheckCPU() {
        if (checkCPU.isSelected()) {
            switchToPage("cpu-bar-graph.fxml");
        }
    }

    // Method to handle GPU checkbox action
    @FXML
    private void handleCheckGPU() {
        if (checkGPU.isSelected()) {
            switchToPage("gpu-bar-graph.fxml");
        }
    }

    // Method to handle Cooler checkbox action
    @FXML
    private void handleCheckCooler() {
        if (checkCooler.isSelected()) {
            switchToPage("cooler-bar-graph.fxml");
        }
    }

    @FXML
    private void handleCheckHardware() {
        switchToPage("hardware-view.fxml");

    }

    // Method to switch to another page
    private void switchToPage(String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            AnchorPane newPage = loader.load();

            newPage.getStylesheets().add(getClass().getResource("table.css").toExternalForm());

            Stage stage = (Stage) mainPane.getScene().getWindow();
            Scene scene = new Scene(newPage);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        chartCPU.getData().add(DBUtility.getTopCpus());

        CPUNumberAxis.setLabel("Price");
        CPUcategoryAxis.setLabel("Cpu Name");


    }


}
