package sample;

import java.io.*;

import org.basex.core.*;
import org.basex.core.cmd.*;
import org.basex.io.serial.*;
import org.basex.query.*;
import org.basex.query.iter.*;
import org.basex.query.value.*;
import org.basex.query.value.item.*;

/**
 * This example demonstrates three variants how XQuery expressions can be
 * evaluated.
 *
 * @author BaseX Team 2005-19, BSD License
 */
public class DBWorker {

    /**
     * Database context.
     */
    static Context context = new Context();

    /**
     * Runs the example code.
     *
     * @param args (ignored) command-line arguments
     * @throws IOException    if an error occurs while serializing the results
     * @throws QueryException if an error occurs while evaluating the query
     * @throws BaseXException if a database command fails
     */
    public static void main(final String... args) throws IOException, QueryException {
        System.out.println("=== RunQueries ===");

        // Evaluate the specified XQuery
        String query = "let $pub := doc('Dev/src/resources/xml/dblp.xml')/*/article[1]/author[1]\n" +
                "return $pub";

        // Process the query by using the database command
        System.out.println("\n* Use the database command:");

        query(query);
    }

    /**
     * This method evaluates a query by using the database command.
     * The results are automatically serialized and printed.
     *
     * @param query query to be evaluated
     * @throws BaseXException if a database command fails
     */
    static void query(final String query) throws BaseXException {
        System.out.println(new XQuery(query).execute(context));
    }

    static String queryResult(final String query) throws BaseXException {
        return new XQuery(query).execute(context);
    }

    /**
     * This method uses the {@link QueryProcessor} to evaluate a query.
     * The resulting items are passed on to a serializer.
     *
     * @param query query to be evaluated
     * @throws QueryException if an error occurs while evaluating the query
     */
    static void process(final String query) throws QueryException {
        // Create a query processor
        try (QueryProcessor proc = new QueryProcessor(query, context)) {
            // Execute the query
            Value result = proc.value();

            // Print result as string.
            System.out.println(result);
        }
    }

    /**
     * This method uses the {@link QueryProcessor} to evaluate a query.
     * The results are iterated one by one and converted to their Java
     * representation, using {{@link Item#toJava()}. This variant is especially
     * efficient if large result sets are expected.
     *
     * @param query query to be evaluated
     * @throws QueryException if an error occurs while evaluating the query
     */
    static void iterate(final String query) throws QueryException {
        // Create a query processor
        try (QueryProcessor proc = new QueryProcessor(query, context)) {
            // Store the pointer to the result in an iterator:
            Iter iter = proc.iter();

            // Iterate through all items and serialize
            for (Item item; (item = iter.next()) != null; ) {
                System.out.println(item.toString());
                System.out.println(item.toJava());
            }
        }
    }
}