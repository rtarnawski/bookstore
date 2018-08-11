import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvBooksImporter {

    public static List<Book> bookImportFromFile(String filename) {

        List<Book> bookList = new ArrayList<>();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));

            StringBuffer stringBuffer = new StringBuffer();

            String nextLine = bufferedReader.readLine();

            while (nextLine != null) {

                String[] split = nextLine.split(";");

                int id = Integer.parseInt(split[0]);
                String title = split[1];
                int isbn = Integer.parseInt(split[2]);
                int publishingDate = Integer.parseInt(split[3]);

                bookList.add(new Book(id, title, isbn, publishingDate));

                nextLine = bufferedReader.readLine();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bookList;
    }


}
