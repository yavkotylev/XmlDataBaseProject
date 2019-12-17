package sample.database;


import org.basex.core.*;
import org.basex.core.cmd.*;
import sample.Utils.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static sample.Utils.isBlank;

/**
 * This example demonstrates three variants how XQuery expressions can be
 * evaluated.
 *
 * @author BaseX Team 2005-19, BSD License
 */
public class DBWorker {
    private final String path = "src/resources/queries/";
    /**
     * Database context.
     */
    static Context context = new Context();

    Result query(final String query) {
        context = new Context();

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
        }finally {
            context.close();
        }
    }

    public String readLineByLineJava8(String fileName) {
        StringBuilder contentBuilder = new StringBuilder();
        try (Stream<String> stream = Files.lines(Paths.get(path + fileName), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append("\n").append(s));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contentBuilder.toString().trim();
    }
}