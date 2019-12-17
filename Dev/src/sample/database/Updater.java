package sample.database;

import org.basex.core.Context;

public class Updater {
    private final Context context  = DBWorker.context;
    private final DBWorker dbWorker;

    public Updater(Context context) {
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
