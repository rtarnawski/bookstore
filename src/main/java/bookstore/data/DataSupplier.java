package bookstore.data;

import java.util.HashMap;
import java.util.Map;

public class DataSupplier {

    private static Map<String, String> fileNames;

    static  {
        fileNames = new HashMap<>();
        fileNames.put("authors", "authors.csv");
        fileNames.put("books", "books.csv");
        fileNames.put("categories", "categories.csv");
    }

    public static String getFileName(String file){
        return fileNames.get(file);
    }
}
