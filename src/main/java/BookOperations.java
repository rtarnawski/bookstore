public class BookOperations {
    public static void printBooks() {
        System.out.println();
        for (Book bookInLoop : BookData.getINSTANCE().getBooks()) {
            System.out.println(bookInLoop.toString());
        }
        System.out.println();
    }

    public static void printBooksInCategory() {
        System.out.println("\nPlease provide ID of category\n");
        for (BooksCategory category : CategoryData.getINSTANCE().getBooksCategories()) {
            System.out.println("ID: " + category.getCategoryID() + "  ----   " + category.getName());
        }
        System.out.println();
        String stringId = Validator.numericValidator(UserInput.scanner.nextLine());
        int categoryId = Integer.parseInt(stringId);
        for (Book bookInLoop : BookData.getINSTANCE().getBooks()) {
            if (bookInLoop.getBooksCategory().getCategoryID() == categoryId)
                System.out.println(bookInLoop.toString());
        }
        System.out.println();

    }

/*    public static void changeBookName() {
        System.out.println("\nPlease provide ID");
        String

    }*/



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

}
