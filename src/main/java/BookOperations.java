import java.util.InputMismatchException;
import java.util.Scanner;

public class BookOperations {


    public static void printBooks(){
        System.out.println();
        for (Book bookInLoop : BookData.getINSTANCE().getBooks() ) {
            System.out.println(bookInLoop.toString());
        }
        System.out.println();
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

}
