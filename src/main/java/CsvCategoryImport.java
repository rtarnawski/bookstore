import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvCategoryImport {

    public static List<BooksCategory> categoryImportFromFile(String filename) throws IOException {

        List<BooksCategory> categoryList = new ArrayList<>();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));

        String nextLine = bufferedReader.readLine();

        while (nextLine != null) {

            String[] split = nextLine.split(";");

            int id = Integer.parseInt(split[0]);
            String name = split[1];
            int priority = Integer.parseInt(split[2]);

            categoryList.add(new BooksCategory(id, name, priority));

            nextLine = bufferedReader.readLine();
        }

        return categoryList;
    }

}
