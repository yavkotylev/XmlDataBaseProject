package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import sample.database.Getter;
import sample.Utils.Result;

import java.util.ArrayList;
import java.util.List;

public class FilterController {
    private final Getter dbGetter = new Getter();

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

    @FXML
    private TextArea resultArea;

    public void searchClicked(ActionEvent event) {
        String title = titleField.getText();
        String author = authorField.getText();

        String from = fromField.getText();
        String to = toField.getText();
        String types = String.join(",", types());

        Result result = dbGetter.getFilteredPublications(title, author, from, to, types);
        if (Result.Status.SUCCESS.equals(result.getStatus())) {
            resultArea.setText(result.getResult());
        } else if (Result.Status.ERROR.equals(result.getStatus())) {
            resultArea.setText(result.getError());
        } else if (Result.Status.EMPTY.equals(result.getStatus())) {
            resultArea.setText("Empty result");
        }

    }

    private List<String> types() {
        List<String> types = new ArrayList<String>();

        if (wwwBox.isSelected()) {
            types.add("\"www\"");
        }

        if (articleBox.isSelected()) {
            types.add("\"article\"");
        }

        if (bachelorBox.isSelected()) {
            types.add("\"book\"");
        }

        if (masterBox.isSelected()) {
            types.add("\"phdthesis\"");
        }

        return types;
    }
}
