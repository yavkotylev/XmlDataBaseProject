package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;

public class MainController {

    public void updateClicked(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/Update.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Update");
            stage.setScene(new Scene(root, 1000, 1000));
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void filterClicked(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/fxml/Filter.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Search");
            stage.setScene(new Scene(root, 800, 600));
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void topClicked(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/fxml/Chart.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Top authors");
            stage.setScene(new Scene(root, 700, 700));
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addClicked(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/fxml/Add.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Add");
            stage.setScene(new Scene(root, 700, 700));
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
