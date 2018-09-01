package bookstore.exporter;

import bookstore.pojo.Author;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class CsvAuthorExporter {
    public static void exportAuthorsToCsvFile(List<Author> authorList) {
        try (PrintWriter printWriter = new PrintWriter(new File("authors.csv"))) {
            StringBuilder stringBuilder = new StringBuilder();
            for (Author author : authorList) {
                stringBuilder.append(author.getAuthorID());
                stringBuilder.append(";");
                stringBuilder.append(author.getName());
                stringBuilder.append(";");
                stringBuilder.append(author.getLastName());
                stringBuilder.append(";");
                stringBuilder.append(author.getAge());
                stringBuilder.append("\n");
            }
            printWriter.write(stringBuilder.toString().trim());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
