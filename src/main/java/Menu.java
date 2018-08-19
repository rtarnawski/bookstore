import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

public class Menu {
    public static void printMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello " + System.getProperty("user.name") + " !");
        while (true) {
            System.out.println("Please choose your option:");
            System.out.println("1 - add book to the bookstore");
            System.out.println("2 - print list of books");
            System.out.println("3 - print list of categories");
            System.out.println("4 - print list of authors");
            System.out.println("5 - print list of books in a given category");
            System.out.println("6 - add new author");
            System.out.println("7 - add new category");
            System.out.println("8 - change view for books");
            System.out.println("9 - exit");
            System.out.println("10 - contact");
            System.out.println("11 - change book's name");
            String usersChoice = scanner.nextLine();
            if (StringUtils.isNumeric(usersChoice)) {
                switch (usersChoice) {
                    case "1":
                        // BookOperations.addBook();
                        continue;
                    case "2":
                        BookPrinter.printBooks(BookData.getINSTANCE().getBooks());
                        continue;
                    case "3":
                        CategoryOperations.printCategories();
                        continue;
                    case "4":
                        AuthorOperations.printAuthors();
                        continue;
                    case "5":
                        BookPrinter.printBooks(BookOperations.findBooksInCategory());
                        continue;
                    case "6":
                        AuthorOperations.addAuthor();
                        continue;
                    case "7":
                        CategoryOperations.addCategory();
                        continue;
                    case "8":
                        BookPrinter.changeView();
                        continue;
                    case "9":
                        CsvAuthorExporter.exportAuthorsToCsvFile(AuthorData.getINSTANCE().getAuthors());
                        CsvCategoryExporter.exportCategoriesToCsvFile(CategoryData.getINSTANCE().getBooksCategories());
                        System.out.println("Thank you and CU next time!");
                        return;
                    case "10":
                        System.out.println("\nbookstore@bookstore.p2\n");
                        continue;
                    case "11":
                        BookOperations.changeBookName(BookOperations.findBookById(BookData.getINSTANCE().getBooks()));
                        continue;
                    default:
                }
            } else {
                System.out.println("Please write a number");
            }
        }
    }
}
