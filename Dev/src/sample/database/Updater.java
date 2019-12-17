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
        dbWorker.setContextAsWritable();
        return dbWorker.query(query);
    }

    public Result deleteTitle(String title) {
        String fileLines = dbWorker.readLineByLineJava8("DeletePubByTitle.xq");
        String query = String.format(fileLines, title);
        dbWorker.setContextAsWritable();
        return dbWorker.query(query);
    }

    public Result deleteAuthor(String author, String title) {
        String fileLines = dbWorker.readLineByLineJava8("DeleteAuthor.xq");
        String query = String.format(fileLines, author, title);
        dbWorker.setContextAsWritable();
        return dbWorker.query(query);
    }

    public Result updateAuthor(String oldAuthor, String newAuthor, String title) {
        String fileLines = dbWorker.readLineByLineJava8("UpdateAuthor.xq");
        String query = String.format(fileLines, oldAuthor, newAuthor, title);
        dbWorker.setContextAsWritable();
        return dbWorker.query(query);
    }
}
