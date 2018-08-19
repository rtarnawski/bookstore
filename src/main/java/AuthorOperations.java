import java.util.List;

public class AuthorOperations {
    public static void printAuthors() {
        List<Author> authorListInPrintMethod = AuthorData.getINSTANCE().getAuthors();
        System.out.println();
        for (Author authorInLoop : authorListInPrintMethod) {
            System.out.println(authorInLoop.toString());
        }
        System.out.println();
    }

    public static void addAuthor() {
        System.out.println("Please provide first name");
        String firstName = Validator.alphaValidator(UserInput.scanner.nextLine());
        System.out.println("Please provide last name");
        String lastName = Validator.alphaValidator(UserInput.scanner.nextLine());
        System.out.println("Please provide age");
        int age = Integer.parseInt(Validator.numericValidator(UserInput.scanner.nextLine()));
        int id = AuthorData.getINSTANCE().getAuthors().size() + 1;
        Author newAuthor = new Author(id, firstName, lastName, age);
        AuthorData.getINSTANCE().getAuthors().add(newAuthor);
        System.out.println("Thank you. Author " + newAuthor.getName() + " " + newAuthor.getLastName() + " has been added\n");
    }
}