package sample.database;

import org.basex.core.Context;

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
        String query = queryString(title, author, from, to, types);

        System.out.println(query);
        return dbWorker.query(query);
    }

    private String queryString(String title, String author, String from, String to, String types) {
        String query = dbWorker.readLineByLineJava8("Filter.xq");
        if (from.isEmpty()) {
            from = "0";
        }
        if (to.isEmpty()) {
            to = "0";
        }
        return String.format(query, title, author, from, to, types);
    }
}
