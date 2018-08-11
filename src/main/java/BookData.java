import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter

public class BookData {

    public static List<Book> getBooks() {
        return books;
    }

    private static List<Book> books = new ArrayList<>();

    private static BookData INSTANCE;

    private BookData() {

    }

public static BookData getINSTANCE(){
        if(INSTANCE == null){
            return new BookData();
        }
        return INSTANCE;
}
   
    
    public static void printBooks(){
        System.out.println();
        for (Book bookInLoop : books ) {
            System.out.println(bookInLoop.toString());
        }
        System.out.println();
    }


}
