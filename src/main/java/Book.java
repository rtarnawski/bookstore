import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
@AllArgsConstructor
public class Book {
    private int id;
    private String title;
    private int isbn;
    private int publishingDate;
    private BookBinding bookBinding;
    private List<Author> authors;
    private BooksCategory booksCategory;

}
