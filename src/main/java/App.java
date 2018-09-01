import lombok.extern.slf4j.Slf4j;

import java.io.IOException;


@Slf4j
public class App {
    public static void main(String[] args) {
        init();
        Menu.printMenu();
    }

    public static void init() {
        try {
            AuthorData.getINSTANCE()
                    .getAuthors()
                    .addAll(CsvAuthorImporter.authorsImportFromFile("authors.csv"));
            CategoryData.getINSTANCE().getBooksCategories().addAll(CsvCategoryImport.categoryImportFromFile("categories.csv"));
            BookData.getINSTANCE()
                    .getBooks()
                    .addAll(CsvBooksImporter.bookImportFromFile("books.csv"));
        } catch (IOException | NumberFormatException e) {
            log.error(e.getMessage());
            System.out.println("Messed up file.... I'm dizzy... I will go now....");
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }
}
