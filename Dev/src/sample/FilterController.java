package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class FilterController {

    @FXML
    private TextField authorField;

    @FXML
    private TextField titleField;

    @FXML
    private TextField fromField;

    @FXML
    private TextField toField;

    @FXML
    private CheckBox masterBox;

    @FXML
    private CheckBox wwwBox;

    @FXML
    private CheckBox bachelorBox;

    @FXML
    private CheckBox articleBox;



    public void searchClicked(ActionEvent event) {
        String title = titleField.getText();
        String author = authorField.getText();


    }

    private List<String> types() {
        List<String> types = new ArrayList<String>();

        if (wwwBox.isSelected()) {
            types.add("www");
        }

        if (articleBox.isSelected()) {
            types.add("article");
        }

        if (bachelorBox.isSelected()) {
            types.add("bchthesis");
        }

        if (masterBox.isSelected()) {
            types.add("mstthesis");
        }

        return types;
    }
}
