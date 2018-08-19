import java.io.IOException;

public class App {
    public static void main(String[] args) {
        try {
            AuthorData.getINSTANCE()
                    .getAuthors()
                    .addAll(CsvAuthorImporter.authorsImportFromFile("authors.csv"));
            CategoryData.getINSTANCE().getBooksCategories().addAll(CsvCategoryImport.categoryImportFromFile("categories.csv"));
            BookData.getINSTANCE()
                    .getBooks()
                    .addAll(CsvBooksImporter.bookImportFromFile("books.csv"));
        } catch (IOException e) {
            System.out.println("Messed up file.... I'm dizzy... I will go now....");
            System.out.println(e.getMessage());
            System.exit(1);
        }
        Menu.printMenu();
    }
}
