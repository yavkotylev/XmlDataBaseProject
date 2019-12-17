package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import sample.database.Getter;
import sample.Utils.Result;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ChartController implements Initializable {

    @FXML
    private BarChart<String, Number> chart;

    class Item {
        String author;
        int value;

        Item(String row) throws Exception {
            String[] ar = row.split("-----");
            if (ar.length != 2) {
                throw new IllegalArgumentException();
            }

            author = ar[0];
            value = Integer.parseInt(ar[1]);
        }
    }

    private final Getter dbGetter = new Getter();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Result result = dbGetter.getAuthorsWithNumberOfPublication();

        String topText = result.getResult();
        if (topText == null) {
            return;
        }

        XYChart.Series<String, Number> dataSeries = new XYChart.Series<String, Number>();
        dataSeries.setName("Top Authors");

        for (Item item : items(topText)) {
            dataSeries.getData().add(new XYChart.Data<String, Number>(item.author, item.value));
        }

        chart.getData().add(dataSeries);
    }

    private List<Item> items(String topText) {
        List<Item> result = new ArrayList<>();

        for (String text : topText.split("\n")) {
            try {
                Item item = new Item(text);
                result.add(item);

                if (result.size() == 10) {
                    return result;
                }
            } catch(Exception e) {
                System.out.println(e.getLocalizedMessage());
            }
        }

        return result;
    }
}
