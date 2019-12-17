package sample.database;

import sample.Utils.Result;

public class Updater {
    private final DBWorker dbWorker;

    public Updater() {
        this.dbWorker = new DBWorker();
    }

    public Result updateTitle(String oldTitle, String newTitle) {
        String query = "let $oldTitle := \"" + oldTitle + "\"" +
                " let $newTitle := \"" + newTitle + "\"" +
                " let $node := doc('src/resources/xml/dblp.xml')/*/*[./title = $oldTitle]" +
                " return replace value of node $node/title with $newTitle";
        return null;
    }
}
