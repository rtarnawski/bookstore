package bookstore;

import bookstore.data.AuthorData;
import bookstore.data.BookData;
import bookstore.data.CategoryData;
import bookstore.data.DataSupplier;
import bookstore.importer.CsvAuthorImporter;
import bookstore.importer.CsvBooksImporter;
import bookstore.importer.CsvCategoryImport;
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
                    .addAll(CsvAuthorImporter.authorsImportFromFile(DataSupplier.getFileName("authors")));
            CategoryData.getINSTANCE().getBooksCategories().addAll(CsvCategoryImport.categoryImportFromFile(DataSupplier.getFileName("categories")));
            BookData.getINSTANCE()
                    .getBooks()
                    .addAll(CsvBooksImporter.bookImportFromFile(DataSupplier.getFileName("books")));
        } catch (IOException | NumberFormatException e) {
            log.error(e.getMessage(), e);
            System.out.println("Messed up file.... I'm dizzy... I will go now....");
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }
}
