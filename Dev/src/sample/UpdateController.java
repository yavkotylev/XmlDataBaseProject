package sample;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import sample.database.DBWorker;
import sample.database.Getter;

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

    //MenuButton
    @FXML
    private ChoiceBox<String> typesChoiceBox;

    //Author buttons
    @FXML
    private Button deleteAuthor;

    public void deleteAuthor(ActionEvent event) {
        System.out.println(deleteAuthorName.getText());
    }

    @FXML
    private Button addAuthor;

    public void addAuthorClicked(ActionEvent event) {
        System.out.println(addAuthorName.getText());
    }

    @FXML
    private Button updateAuthor;

    public void updateAuthorClicked(ActionEvent event) {
        System.out.println("Old name = " + oldAuthorName.getText() + "\nNew name = " + newAuthorName.getText());
    }

    //Title buttons
    @FXML
    private Button deleteTitle;

    public void deleteTitleClicked(ActionEvent event) {
        System.out.println(getter.findPublicationByTitle(mainTitleName.getText()).getResult());
    }

    @FXML
    private Button addTitle;

    public void addTitleClicked(ActionEvent event) {
        System.out.println(newTitleName.getText() + " " + typesChoiceBox.getValue());
    }

    @FXML
    private Button updateTitle;

    public void updateTitleClicked(ActionEvent event) {
        String oldName = mainTitleName.getText();
        String newName = updateTitleName.getText();
        if (!Utils.isBlank(oldName) && !Utils.isBlank(newName)) {
            //dbWorker.updateTitle(oldName, newName);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

}