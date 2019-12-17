package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import sample.database.Getter;

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

        String query = queryString(title, author, from, to, types);

        System.out.println(query);

        try {
            String result = "lpl";// dbGetter.queryResult(query);
            System.out.println("RESULT:");
            System.out.println(result);

            resultArea.setText(result);

        } catch (Exception e) {
            String message = e.getLocalizedMessage();
            System.out.println(message);
            resultArea.setText(message);
        }
    }

    private String queryString(String title, String author, String from, String to, String types) {
        String query = ";e;";//dbGetter readLineByLineJava8("Queries/Filter.xq");
        if (from.isEmpty()) {
            from = "0";
        }
        if (to.isEmpty()) {
            to = "0";
        }
        return String.format(query, title, author, from, to, types);
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
            types.add("\"mstthesis\"");
        }

        return types;
    }
}
