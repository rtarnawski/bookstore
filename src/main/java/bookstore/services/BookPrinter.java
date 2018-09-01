package bookstore.services;

import bookstore.pojo.Book;
import bookstore.utils.UserInput;
import bookstore.utils.Validator;

import java.util.List;

public class BookPrinter {
    private static int viewmode = 0;

    public static void changeView() {
        System.out.println("\n Please choose your preferences:");
        System.out.println("97 = Year, Title, ISBN");
        System.out.println("98 = Title, Year, ISBN");
        System.out.println("99 = ISBN, Title, Year");
        System.out.println("Any other = Default - all details");
        viewmode = Integer.parseInt(Validator.numericValidator(UserInput.scanner.nextLine()));
    }

    public static void printBooks(List<Book> bookList) {
        if (bookList.isEmpty()) {
            System.out.println("\nbookstore.pojo.Book not found\n");
        } else {
            if (viewmode == 97) {
                viewFirstYear(bookList);
            } else if (viewmode == 98) {
                viewFirstTitle(bookList);
            } else if (viewmode == 99) {
                viewFirstISBN(bookList);
            } else
                defaultView(bookList);
        }
    }

    public static void defaultView(List<Book> bookList) {
        System.out.println();
        bookList.forEach(book -> System.out.println(book.toString()));
        System.out.println();
    }

    public static void viewFirstYear(List<Book> bookList) {
        System.out.println();
        for (Book bookInLoop : bookList) {
            System.out.println("Year: " + bookInLoop.getPublishingDate() +
                    ", Title: " + bookInLoop.getTitle() + ", ISBN: " + bookInLoop.getIsbn());
        }
        System.out.println();
    }

    public static void viewFirstTitle(List<Book> bookList) {
        System.out.println();
        for (Book bookInLoop : bookList) {
            System.out.println("Title: " + bookInLoop.getTitle() +
                    ", Year: " + bookInLoop.getPublishingDate() + ", ISBN: " + bookInLoop.getIsbn());
        }
        System.out.println();
    }

    public static void viewFirstISBN(List<Book> bookList) {
        System.out.println();
        for (Book bookInLoop : bookList) {
            System.out.println("ISBN: " + bookInLoop.getIsbn() +
                    ", Title: " + bookInLoop.getTitle() + ", Year: " + bookInLoop.getPublishingDate());
        }
        System.out.println();
    }
}
