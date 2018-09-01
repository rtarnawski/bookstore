package bookstore;

import bookstore.data.AuthorData;
import bookstore.data.BookData;
import bookstore.data.CategoryData;
import bookstore.exporter.CsvAuthorExporter;
import bookstore.exporter.CsvBooksExporter;
import bookstore.exporter.CsvCategoryExporter;
import bookstore.pojo.Author;
import bookstore.pojo.Book;
import bookstore.pojo.BooksCategory;
import bookstore.services.BookPrinter;
import bookstore.utils.UserInput;
import bookstore.services.AuthorOperations;
import bookstore.services.BookOperations;
import bookstore.services.CategoryOperations;
import bookstore.utils.Validator;

import java.util.List;
import java.util.Optional;

public class Menu {
    public static void printMenu() {
        System.out.println("Hello " + System.getProperty("user.name") + " !");
        while (true) {
            listChoices();
            try {
                int usersChoice = Integer.parseInt(Validator.numericValidator(UserInput.scanner.nextLine()));
                List<Book> bookListInMain = BookData.getINSTANCE().getBooks();
                List<Author> authorListInMain = AuthorData.getINSTANCE().getAuthors();
                List<BooksCategory> booksCategoriesListInMain = CategoryData.getINSTANCE().getBooksCategories();
                switch (usersChoice) {
                    case 1:
                        // bookstore.services.BookOperations.addBook();
                        continue;
                    case 2:
                        BookPrinter.printBooks(bookListInMain);
                        continue;
                    case 3:
                        CategoryOperations.printCategories();
                        continue;
                    case 4:
                        AuthorOperations.printAuthors(authorListInMain);
                        continue;
                    case 5:
                        BookPrinter.printBooks(BookOperations.findBooksInCategory(bookListInMain, booksCategoriesListInMain));
                        continue;
                    case 6:
                        AuthorOperations.addAuthor();
                        continue;
                    case 7:
                        CategoryOperations.addCategory();
                        continue;
                    case 8:
                        BookPrinter.changeView();
                        continue;
                    case 9:
                        CsvAuthorExporter.exportAuthorsToCsvFile(authorListInMain);
                        CsvCategoryExporter.exportCategoriesToCsvFile(booksCategoriesListInMain);
                        CsvBooksExporter.exportBooksToCsvFile(bookListInMain);
                        System.out.println("Thank you and CU next time!");
                        return;
                    case 10:
                        System.out.println("\nbookstore@bookstore.pl\n");
                        continue;
                    case 11:
                        Optional<Book> bookById = BookOperations.findBookById(bookListInMain);
                        bookById.ifPresent(BookOperations::changeBookName);
                        continue;
                    case 12:
                        Optional<Author> author = AuthorOperations.findAuthor(authorListInMain);
                        author.ifPresent(AuthorOperations::changeAuthorsAge);
                        continue;
                    case 13:
                        List<Book> booksByAuthor = BookOperations.findBooksByAuthor(bookListInMain, authorListInMain);
                        BookPrinter.printBooks(booksByAuthor);
                        continue;
                    case 14:
                        AuthorOperations.printAuthorsWithNumberOfBooks(bookListInMain, authorListInMain);
                        continue;
                    case 15:
                        CategoryOperations.changeCategoryName(booksCategoriesListInMain);
                        continue;
                    case 16:
                        CsvAuthorExporter.exportAuthorsToCsvFile(authorListInMain);
                        CsvCategoryExporter.exportCategoriesToCsvFile(booksCategoriesListInMain);
                        CsvBooksExporter.exportBooksToCsvFile(bookListInMain);
                        System.out.println("Work saved");
                        continue;
                    default:
                        System.out.println("\nPlease provide one of the numbers presented\n");
                }
            } catch (NumberFormatException ex) {
                System.out.println("\nPlease provide one of the numbers presented\n");
            }
        }
    }

    public static void listChoices() {
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
        System.out.println("12 - change author's age");
        System.out.println("13 - print list of books by Author");
        System.out.println("14 - print author's last names with number of published books");
        System.out.println("15 - change category's name");
        System.out.println("16 - save");
        System.out.println();
    }
}

