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

import static sample.Utils.isBlank;


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
    private TextField updateTitleName;
    @FXML
    private TextArea updatedPublication;

    public void deleteAuthor(ActionEvent event) {
        String author = deleteAuthorName.getText();
        if (isBlank(author)) {
            setInfo("Fill author name for delete!");
            return;
        }
        if (!isMainTitleNameFilled()) {
            return;
        }
        Result res = dbUpdater.deleteAuthor(author, mainTitleName.getText());
        switch (res.getStatus()) {
            case SUCCESS:
            case EMPTY:
                setUpdatedPublication(mainTitleName.getText(), "Publication with deleted author:");
                break;
            case ERROR:
                setInfo("Error:\n" + res.getError());
        }

    }

    public void addAuthorClicked(ActionEvent event) {
        String newAuthor = addAuthorName.getText();
        if (isBlank(newAuthor)) {
            setInfo("Fill new author name!");
            return;
        }
        if (!isMainTitleNameFilled()) {
            return;
        }
        Result result = dbUpdater.addAuthor(newAuthor, mainTitleName.getText());
        switch (result.getStatus()) {
            case SUCCESS:
            case EMPTY:
                setUpdatedPublication(mainTitleName.getText(), "Publication with new author:");
                break;
            case ERROR:
                setInfo("Error:\n" + result.getError());
        }

    }

    public void updateAuthorClicked(ActionEvent event) {
        if (isBlank(oldAuthorName.getText())) {
            setInfo("Old author Name is empty");
            return;
        }
        if (isBlank(newAuthorName.getText())) {
            setInfo("New author Name is empty");
            return;
        }
        if (!isMainTitleNameFilled()) {
            return;
        }
        Result res = dbUpdater.updateAuthor(oldAuthorName.getText(), newAuthorName.getText(),
                mainTitleName.getText());
        switch (res.getStatus()) {
            case SUCCESS:
            case EMPTY:
                setUpdatedPublication(mainTitleName.getText(), "Publication with updated author: ");
                break;
            case ERROR:
                setInfo("Error :\n" + res.getError());
        }

    }

    public void deleteTitleClicked(ActionEvent event) {
        Result res = dbUpdater.deleteTitle(mainTitleName.getText());
        switch (res.getStatus()) {
            case SUCCESS:
            case EMPTY:
                setInfo("titleDeleted!");
                break;
            case ERROR:
                setInfo("Error: \n" + res.getError());
        }
    }


    public void updateTitleClicked(ActionEvent event) {
        String oldTitle = mainTitleName.getText();
        String newTitle = updateTitleName.getText();
        if (isBlank(newTitle)) {
            setInfo("New title is empty");
            return;
        }
        if (isBlank(oldTitle)) {
            setInfo("Title for update is empty");
            return;
        }
        dbUpdater.updateTitle(oldTitle, newTitle);
        setUpdatedPublication(newTitle, "Publication with updated title:");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    private void setUpdatedPublication(String title, String infoBeforeUpdate) {
        Result res = dbGetter.getPublicationByTitle(title);
        if (res.getStatus().equals(Result.Status.SUCCESS)) {
            updatedPublication.setText(infoBeforeUpdate + "\n" + res.getResult());
        } else if (res.getStatus().equals(Result.Status.ERROR)) {
            updatedPublication.setText("Executed with error:\n" + res.getError());
        } else if (res.getStatus().equals(Result.Status.EMPTY)) {
            updatedPublication.setText("Empty res");
        }
    }

    private void setInfo(String info) {
        updatedPublication.setText(info);
    }

    private boolean isMainTitleNameFilled() {
        if (isBlank(mainTitleName.getText())) {
            setInfo("Fill title name!");
            return false;
        }
        return true;
    }
}