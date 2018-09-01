package bookstore.services;

import bookstore.utils.Validator;
import bookstore.pojo.Author;
import bookstore.pojo.Book;
import bookstore.pojo.BooksCategory;
import bookstore.utils.UserInput;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BookOperations {
    public static List<Book> findBooksInCategory(List<Book> bookList, List<BooksCategory> categoryList) {
        BooksCategory categoryByIdFromUser = CategoryOperations.findCategoryByIdFromUser(categoryList);
        List<Book> bookListInCategory = new ArrayList<>();
        return bookList.stream()
                .filter(book -> book.getBooksCategory().equals(categoryByIdFromUser))
                .collect(Collectors.toList());
    }

    public static Optional<Book> findBookById(List<Book> bookList) {
        System.out.println("\nPlease provide ID");
        int id = Integer.parseInt(Validator.numericValidator(UserInput.scanner.nextLine()));
        for (Book bookInLoop : bookList) {
            if (bookInLoop.getId() == id) {
                return Optional.ofNullable(bookInLoop);
            }
        }
        System.out.println("No such ID");
        return Optional.empty();
    }

    public static List<Book> findBooksByAuthor(List<Book> bookList, List<Author> authorList) {
        Optional<Author> author = AuthorOperations.findAuthor(authorList);
        List<Book> booksByAuthor = new ArrayList<>();
        if (author.isPresent()) {
            Author authorFromOptional = author.get();
            booksByAuthor = listBooksByAuthor(bookList, authorFromOptional);
        }
        return booksByAuthor;
    }

    public static List<Book> listBooksByAuthor(List<Book> bookList, Author authorFromOptional) {
        List<Book> booksByAuthor = new ArrayList<>();
        for (Book book : bookList) {
            List<Author> authorsInLoop = book.getAuthors();
            if (authorsInLoop.contains(authorFromOptional)) {
                booksByAuthor.add(book);
            }
        }
        return booksByAuthor;
    }

    public static void changeBookName(Book book) {
        System.out.println("Please provide new title");
        String newTitle = Validator.alphaValidator(UserInput.scanner.nextLine());
        book.setTitle(newTitle);
        System.out.println("\nNew title  has benn set\n");
    }
}


