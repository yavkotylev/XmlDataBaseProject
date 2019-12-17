package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

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
            String result =  DBWorker.queryResult(query);
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
        String query = readLineByLineJava8("Queries/Filter.xq");
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

    private String readLineByLineJava8(String filePath)
    {
        StringBuilder contentBuilder = new StringBuilder();
        try (Stream<String> stream = Files.lines( Paths.get(filePath), StandardCharsets.UTF_8))
        {
            stream.forEach(s -> contentBuilder.append("\n").append(s));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return contentBuilder.toString().trim();
    }
}
