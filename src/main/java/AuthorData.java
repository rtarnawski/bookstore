import java.util.ArrayList;
import java.util.List;

public class AuthorData {
    public static AuthorData INSTANCE;
    private List<Author> authors = new ArrayList<>();

    private AuthorData() {
    }

    public static AuthorData getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new AuthorData();
        }
        return INSTANCE;
    }

    public List<Author> getAuthors() {
        return authors;
    }
}