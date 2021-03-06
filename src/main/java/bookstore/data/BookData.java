package bookstore.data;

import lombok.Getter;
import bookstore.pojo.Book;

import java.util.ArrayList;
import java.util.List;

@Getter
public class BookData {
    private static List<Book> books = new ArrayList<>();
    private static BookData INSTANCE = new BookData();

    private BookData() {
    }

    public static BookData getINSTANCE() {
        return INSTANCE;
    }

    public List<Book> getBooks() {
        return books;
    }
}
