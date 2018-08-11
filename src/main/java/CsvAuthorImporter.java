import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvAuthorImporter {

    public static List<Author> authorsImportFromFile(String filename) {

        List<Author> authorList = new ArrayList<>();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));

            StringBuffer stringBuffer = new StringBuffer();

            String nextLine = bufferedReader.readLine();

            while (nextLine != null) {

                String[] split = nextLine.split(";");

                int id = Integer.parseInt(split[0]);
                String name = split[1];
                String lastName = split[2];
                int age = Integer.parseInt(split[3]);

                authorList.add(new Author(id, name, lastName, age));

                nextLine = bufferedReader.readLine();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return authorList;
    }
}
