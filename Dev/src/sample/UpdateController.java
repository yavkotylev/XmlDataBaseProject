package sample;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import sample.database.Updater;


public class UpdateController implements Initializable {

    private final Updater dbUpdater = new Updater();
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
        dbUpdater.deleteTitle(mainTitleName.getText());
    }

    public void addTitleClicked(ActionEvent event) {
        System.out.println(newTitleName.getText() + " " + typesChoiceBox.getValue());
    }

    public void updateTitleClicked(ActionEvent event) {
        String oldTitle = mainTitleName.getText();
        String newTitle = updateTitleName.getText();
        dbUpdater.updateTitle(oldTitle, newTitle);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

}