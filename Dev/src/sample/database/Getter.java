package sample.database;

import sample.Utils.Result;

public class Getter {
    private final DBWorker dbWorker;

    public Getter() {
        this.dbWorker = new DBWorker();
    }

    public Result findPublicationByTitle(String title) {
        String fileLines = dbWorker.readLineByLineJava8("GetPublicationByTitle.xq");
        String query = String.format(fileLines, title);
        return dbWorker.query(query);
    }

    public Result getFilteredPublications(String title, String author, String from, String to, String types) {
        String fileLines = dbWorker.readLineByLineJava8("Filter.xq");
        if (from.isEmpty()) {
            from = "0";
        }
        if (to.isEmpty()) {
            to = "0";
        }
        String query = String.format(fileLines, title, author, from, to, types);
        return dbWorker.query(query);
    }

    public Result getAuthorsWithNumberOfPublication() {
        String fileLines = dbWorker.readLineByLineJava8("GetAuthorsByNumberOfPublications.xq");
        return dbWorker.query(fileLines);
    }

    public Result getPublicationByTitle(String title){
        String fileLines = dbWorker.readLineByLineJava8("GetPublicationByTitle.xq");
        return dbWorker.query(String.format(fileLines, title));
    }
}
