package sample;

import java.net.URL;
import java.util.ResourceBundle;
import sample.Utils.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import sample.database.DBWorker;
import sample.database.Getter;

import static sample.Utils.isBlank;

public class UpdateController implements Initializable {

    private final DBWorker dbWorker = new DBWorker();
    private final Getter getter = new Getter();
    //Author textFields
    @FXML
    private TextField deleteAuthorName;
    @FXML
    private TextField addAuthorName;
    @FXML
    private TextField oldAuthorName;
    @FXML
    private TextField newAuthorName;

    //Title textFields
    @FXML
    private TextField mainTitleName;
    @FXML
    private TextField newTitleName;
    @FXML
    private TextField updateTitleName;

    @FXML
    private ChoiceBox<String> typesChoiceBox;

    public void deleteAuthor(ActionEvent event) {
        System.out.println(deleteAuthorName.getText());
    }

    public void addAuthorClicked(ActionEvent event) {
        System.out.println(addAuthorName.getText());
    }

    public void updateAuthorClicked(ActionEvent event) {
        System.out.println("Old name = " + oldAuthorName.getText() + "\nNew name = " + newAuthorName.getText());
    }

    public void deleteTitleClicked(ActionEvent event) {
        System.out.println(getter.getAuthorsWithNumberOfPublication());
    }

    public void addTitleClicked(ActionEvent event) {
        System.out.println(newTitleName.getText() + " " + typesChoiceBox.getValue());
    }

    public void updateTitleClicked(ActionEvent event) {
        String oldName = mainTitleName.getText();
        String newName = updateTitleName.getText();
        if (!isBlank(oldName) && !isBlank(newName)) {
            //dbWorker.updateTitle(oldName, newName);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

}