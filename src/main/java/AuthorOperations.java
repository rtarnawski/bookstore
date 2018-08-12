import java.util.List;

public class AuthorOperations {

    public static void printAuthors(){

        List<Author> authorListInPrintMethod = AuthorData.getINSTANCE().getAuthors();

        System.out.println();
        for (Author authorInLoop : authorListInPrintMethod) {
            System.out.println(authorInLoop.toString());
        }

        System.out.println();
    }

}