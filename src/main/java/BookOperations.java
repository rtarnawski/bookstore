import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookOperations {
    public static List<Book> findBooksInCategory() {
        System.out.println("\nPlease provide ID of category\n");
        for (BooksCategory category : CategoryData.getINSTANCE().getBooksCategories()) {
            System.out.println("ID: " + category.getCategoryID() + "  ----   " + category.getName());
        }
        System.out.println();
        int categoryId = Integer.parseInt(Validator.numericValidator(UserInput.scanner.nextLine()));
        List<Book> bookListInCategory = new ArrayList<>();
        for (Book bookInLoop : BookData.getINSTANCE().getBooks()) {
            if (bookInLoop.getBooksCategory().getCategoryID() == categoryId)
                bookListInCategory.add(bookInLoop);
        }
        return bookListInCategory;
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

    public static void changeBookName(Optional<Book> book) {
        if (book.isPresent()) {
            System.out.println("Please provide new title");
            String newTitle = Validator.alphaValidator(UserInput.scanner.nextLine());
            book.get().setTitle(newTitle);
            System.out.println();
        }
    }
}


/*
    public static void addBook(){

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("\nPlease provide:");
            System.out.println("title");
            String title = scanner.nextLine();
            System.out.println("ISBN");
            int isbn = scanner.nextInt();
            System.out.println("year of publishing");
            int publishingDate = scanner.nextInt();
            int id = BookData.getBooks().size() + 1;

            BookData.getBooks().add(new Book(id, title, isbn, publishingDate));
            System.out.println("Thank you. Your book " + title + " has been added");
        }catch (InputMismatchException ex){
            System.out.println("Wrong type");
            return;
        }
    }*/


