package sample.database;

import sample.Utils.Result;

public class Updater {
    private final DBWorker dbWorker;

    public Updater() {
        this.dbWorker = new DBWorker();
    }

    public Result updateTitle(String oldTitle, String newTitle) {
        String fileLines = dbWorker.readLineByLineJava8("UpdateTitle.xq");
        String query = String.format(fileLines, oldTitle, newTitle);
        return dbWorker.query(query);
    }

    public Result deleteTitle(String title) {
        String fileLines = dbWorker.readLineByLineJava8("DeletePubByTitle.xq");
        String query = String.format(fileLines, title);
        return dbWorker.query(query);
    }
}
