import java.util.ArrayList;
import java.util.List;

public class AuthorData {

    private List<Author> authors = new ArrayList<>();

    public List<Author> getAuthors() {
        return authors;
    }

    private AuthorData() {
    }

    public static AuthorData INSTANCE;

    public static AuthorData getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new AuthorData();
        }
        return INSTANCE;
    }
}