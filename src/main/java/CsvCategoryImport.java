import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CsvCategoryImport {

    public static List<BooksCategory> categoryImportFromFile(String filename) {

        List<BooksCategory> categoryList = new ArrayList<>();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));

            StringBuffer stringBuffer = new StringBuffer();

            String nextLine = bufferedReader.readLine();

            while (nextLine != null) {

                String[] split = nextLine.split(";");

                int id = Integer.parseInt(split[0]);
                String name = split[1];
                int priority = Integer.parseInt(split[2]);

                categoryList.add(new BooksCategory(id, name, priority));

                nextLine = bufferedReader.readLine();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return categoryList;
    }

}
