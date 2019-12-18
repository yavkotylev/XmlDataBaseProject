package sample.database;


import org.basex.core.*;
import org.basex.core.cmd.*;
import sample.Utils.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Stream;

import static sample.Utils.isBlank;

/**
 * This example demonstrates three variants how XQuery expressions can be
 * evaluated.
 *
 * @author BaseX Team 2005-19, BSD License
 */
public class DBWorker {
    private final String path = "queries/";
    /**
     * Database context.
     */
    static Context context = new Context();

    Result query(final String query) {
        System.out.println("Start execute:\n" + query);
        try {
            String res = new XQuery(query).execute(context);
            if (isBlank(res)) {
                System.out.println("Empty result!");
                return new Result(Result.Status.EMPTY, null, null);
            }
            System.out.println("Executed successfully with res:\n " + res);
            return new Result(Result.Status.SUCCESS, res);
        } catch (Exception e) {
            System.out.println("Executed with error:\n " + e.toString());
            return new Result(Result.Status.ERROR, null, e.toString());
        }
    }

    public String readLineByLineJava8(String fileName) {
        StringBuilder contentBuilder = new StringBuilder();
        try (Stream<String> stream = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream(path + fileName))).lines()) {
            stream.forEach(s -> contentBuilder.append("\n").append(s));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return contentBuilder.toString().trim();
    }

    public void setContextAsWritable() {
        try {
            context.options.assign("WRITEBACK", "true");
        } catch (Exception e) {
            System.out.println("Error with context");
        }
    }
}