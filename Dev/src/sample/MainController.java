package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {

    public void updateClicked(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Update");
            stage.setScene(new Scene(root, 600, 600));
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void filterClicked(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("Filter.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Filter");
            stage.setScene(new Scene(root, 600, 600));
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
