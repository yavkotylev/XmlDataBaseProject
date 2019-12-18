package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sample.database.Updater;

public class AddController {

    private Updater updater = new Updater();

    @FXML
    private TextField authorField;

    @FXML
    private TextField titleField;

    @FXML
    private TextField yearField;

    @FXML
    private TextArea resultArea;

    public void addClicked(ActionEvent event) {
        String authors = String.join("\",\"", authorField.getText().split(","));
        String title = titleField.getText();
        String year = yearField.getText();

        if (authors.isEmpty() || title.isEmpty() || year.isEmpty()) {
            resultArea.setText("Fill all fields!");
            return;
        }

        Utils.Result result = updater.addPublication(title, authors, year);

        if (Utils.Result.Status.EMPTY.equals(result.getStatus())) {
            resultArea.setText(result.toString());
        } else {
            resultArea.setText(result.toString());
        }
    }
}
