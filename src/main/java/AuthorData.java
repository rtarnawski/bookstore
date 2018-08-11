import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class AuthorData {

    private static List<Author> authors = new ArrayList<>();

    public List<Author> getAuthors() {
        return authors;
    }

    private AuthorData() {
    }

    public static AuthorData INSTANCE = new AuthorData();

    public static AuthorData getINSTANCE(){

        return INSTANCE;
    }
}
