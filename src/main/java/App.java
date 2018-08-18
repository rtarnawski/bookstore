import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.Scanner;

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

        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello user!");

        while (true) {
            System.out.println("Please choose your option:");
            System.out.println("1 - add book to the bookstore");
            System.out.println("2 - print list of books");
            System.out.println("3 - print list of categories");
            System.out.println("4 - print list of authors");

            System.out.println("9 - exit");
            System.out.println("10 - contact");

            String usersChoice = scanner.nextLine();
            if (StringUtils.isNumeric(usersChoice)) {
                switch (usersChoice) {
                    case "1":
                        // BookOperations.addBook();
                        continue;
                    case "2":
                        BookOperations.printBooks();
                        continue;
                    case "3":
                        CategoryOperations.printCategories();
                        continue;
                    case "4":
                        AuthorOperations.printAuthors();
                        continue;

                    case "9":
                        System.out.println("Thank you and CU next time!");
                        return;
                    case "10":
                        System.out.println("\nbookstore@bookstore.p2\n");
                        continue;
                    default:
                }
            } else {
                System.out.println("Please write a number");
            }
        }
    }
}
