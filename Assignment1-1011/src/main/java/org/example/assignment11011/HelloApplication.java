package org.example.assignment11011;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException , SQLException{
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hardware-view.fxml"));
        AnchorPane root = fxmlLoader.load();
        stage.setTitle("Computer Hardware");
        root.getStylesheets().add(getClass().getResource("table.css").toExternalForm());
        stage.setScene(new Scene(root));
        stage.show();


    }

    public static void main(String[] args) throws SQLException {
        launch();
    }
}