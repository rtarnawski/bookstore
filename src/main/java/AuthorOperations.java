import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AuthorOperations {
    public static void printAuthors(List<Author> authorList) {
        System.out.println();
        for (Author authorInLoop : authorList) {
            System.out.println(authorInLoop.toString());
        }
        System.out.println();
    }

    public static void printAuthorsWithNumberOfBooks(List<Book> bookList, List<Author> authorList) {
        System.out.println();
        for (Author authorInLoop : authorList) {
            long bookCount = bookList.stream().filter(book -> book.getAuthors().contains(authorInLoop)).count();
            System.out.printf("Author " + authorInLoop.getLastName() + " published %d books\n", bookCount);
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

    public static Optional<Author> findAuthorById(List<Author> authorList, int id) {
        Optional<Author> authorById = authorList.stream().filter(author -> author.getAuthorID() == id).findAny();
        if (authorById.isPresent()) {
        } else {
            System.out.println("Author not found");
        }
        return authorById;
    }

    public static Optional<Author> findAuthorByLastName(List<Author> authorList, String lastName) {
        List<Author> authorByLastName = authorList.stream().filter(author -> author.getLastName().equalsIgnoreCase(lastName)).collect(Collectors.toList());
        if (authorByLastName.isEmpty()) {
            System.out.println("Author not found");
            return Optional.empty();
        } else if (authorByLastName.size() == 1) {
            return Optional.ofNullable(authorByLastName.get(0));
        } else {
            System.out.println("\nThere are " + authorByLastName.size() + " authors with this last name\n");
            authorByLastName.stream().forEach(author -> System.out.println(author));
            System.out.println("\nPlease provide author's ID\n");
            int searchId = Integer.parseInt(Validator.numericValidator(UserInput.scanner.nextLine()));
            return findAuthorById(authorList, searchId);
        }
    }

    public static Optional<Author> findAuthor(List<Author> authorList) {
        System.out.println("\nPlease provide author's ID or last name");
        String searchWord = UserInput.scanner.nextLine();
        if (StringUtils.isNumeric(searchWord)) {
            return findAuthorById(authorList, Integer.parseInt(searchWord));
        } else {
            return findAuthorByLastName(authorList, searchWord);
        }
    }

    public static void changeAuthorsAge(Author author) {
        System.out.println("\nPlease provide new age\n");
        author.setAge(Integer.parseInt(Validator.numericValidator(UserInput.scanner.nextLine())));
        System.out.println("\nNew age is set\n");
    }
}

