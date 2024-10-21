package org.example.assignment11011;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class HardwareViewController implements Initializable {
    @FXML
    private CheckBox checkCPU;

    @FXML
    private CheckBox checkCooler;

    @FXML
    private CheckBox checkGPU;

    @FXML
    private TableColumn<?, ?> colCPU;

    @FXML
    private TableColumn<?, ?> colCPULoad;

    @FXML
    private TableColumn<?, ?> colCPUPrice;

    @FXML
    private TableColumn<?, ?> colCooler;

    @FXML
    private TableColumn<?, ?> colFPS;

    @FXML
    private TableColumn<?, ?> colG3D;

    @FXML
    private TableColumn<?, ?> colGPU;

    @FXML
    private TableColumn<?, ?> colGPUPrice;

    @FXML
    private TableColumn<?, ?> colRPM;

    @FXML
    private TableColumn<?, ?> colResolution;
    @FXML
    private TableView<CpuBenchmark> tableHardwareLeft;

    @FXML
    private TableView<GpuBenchmark> tableHardwareMid;

    @FXML
    private TableView<CoolerBenchmark> tableHardwareRight;


    @FXML
    private AnchorPane mainPane;

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

        colCPU.setCellValueFactory(new PropertyValueFactory<>("name"));
        colCPUPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colFPS.setCellValueFactory(new PropertyValueFactory<>("fps"));
        colResolution.setCellValueFactory(new PropertyValueFactory<>("resolution"));

        colGPU.setCellValueFactory(new PropertyValueFactory<>("name"));
        colGPUPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colG3D.setCellValueFactory(new PropertyValueFactory<>("G3D_mark"));

        colCooler.setCellValueFactory(new PropertyValueFactory<>("name"));
        colRPM.setCellValueFactory(new PropertyValueFactory<>("rpm"));
        colCPULoad.setCellValueFactory(new PropertyValueFactory<>("cpu_load"));

        DBUtility dbUtility = new DBUtility();

        try {
            ArrayList<CpuBenchmark> cpuBenchmarks = dbUtility.getAllCpuBenchmark();
            ArrayList<GpuBenchmark> gpuBenchmarks = dbUtility.getAllGpuBenchmark();
            ArrayList<CoolerBenchmark> coolerBenchmarks = dbUtility.getAllCoolerBenchmark();

            tableHardwareLeft.getItems().setAll(cpuBenchmarks);
            tableHardwareMid.getItems().setAll(gpuBenchmarks);
            tableHardwareRight.getItems().setAll(coolerBenchmarks);

        } catch(SQLException e){
            throw new RuntimeException(e);
        }

    }


}
