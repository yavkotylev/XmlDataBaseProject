package sample;

import java.net.URL;
import java.util.ResourceBundle;

import sample.Utils.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import sample.database.Getter;
import sample.database.Updater;


public class UpdateController implements Initializable {

    private final Updater dbUpdater = new Updater();
    private final Getter dbGetter = new Getter();

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
    private TextArea updatedPublication;

    @FXML
    private ChoiceBox<String> typesChoiceBox;

    public void deleteAuthor(ActionEvent event) {
        System.out.println(deleteAuthorName.getText());
        setUpdatedPublication(mainTitleName.getText());
    }

    public void addAuthorClicked(ActionEvent event) {
        System.out.println(addAuthorName.getText());
        setUpdatedPublication(mainTitleName.getText());
    }

    public void updateAuthorClicked(ActionEvent event) {
        System.out.println("Old name = " + oldAuthorName.getText() + "\nNew name = " + newAuthorName.getText());
        setUpdatedPublication(mainTitleName.getText());
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
        setUpdatedPublication(newTitle);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    private void setUpdatedPublication(String title) {
        Result res = dbGetter.getPublicationByTitle(title);
        if (res.getStatus().equals(Result.Status.SUCCESS)) {
            updatedPublication.setText(res.getResult());
        } else if (res.getStatus().equals(Result.Status.ERROR)) {
            updatedPublication.setText("Executed with error:\n" + res.getError());
        } else if (res.getStatus().equals(Result.Status.EMPTY)) {
            updatedPublication.setText("Empty res");
        }
    }
}