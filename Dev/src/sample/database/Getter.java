package sample.database;

import org.basex.core.Context;

public class Getter {
    private final Context context = DBWorker.context;
    private final DBWorker dbWorker;

    public Getter() {
        this.dbWorker = new DBWorker();
    }

    public Result findPublicationByTitle(String title) {
        String fileLines =  dbWorker.readLineByLineJava8("GetPublicationByTitle.xq");
        String query = String.format(fileLines, title);
        System.out.println("titile = " + title);
        return dbWorker.query(query);
    }
}
