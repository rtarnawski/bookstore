import lombok.Getter;

import java.util.ArrayList;
import java.util.List;


@Getter

public class BookData {

    public List<Book> getBooks() {
        return books;
    }

    private static List<Book> books = new ArrayList<>();

    private static BookData INSTANCE = new BookData();

    private BookData() {

    }

    public static BookData getINSTANCE() {

        return INSTANCE;
    }


}
