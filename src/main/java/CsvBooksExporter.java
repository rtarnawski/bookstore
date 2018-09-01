import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class CsvBooksExporter {
    public static void exportBooksToCsvFile(List<Book> bookList) {
        try (FileWriter writer = new FileWriter(new File("authors.csv"))) {
            StringBuilder builder = new StringBuilder();
            for (Book book : bookList) {
                builder.append(book.getId());
                builder.append(";");
                builder.append(book.getTitle());
                builder.append(";");
                builder.append(book.getIsbn());
                builder.append(";");
                builder.append(book.getPublishingDate());
                builder.append(";");
                builder.append(book.getBookBinding());
                builder.append(";");
                builder.append(book.getAuthors().stream().map(author -> String.valueOf(author.getAuthorID())).
                        collect(Collectors.joining(",")));
                builder.append(";");
                builder.append(book.getBooksCategory());
                builder.append("\n");
            }
            writer.write(builder.toString().trim());
        } catch (IOException e) {
            System.out.println("Export error. Please try again later");
            System.out.println(e.getMessage());
        }
    }
}
