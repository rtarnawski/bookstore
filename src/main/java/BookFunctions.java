import java.util.List;

public class BookFunctions {



    public static Book findBookByISBN(List<Book> bookList, int isbn){

        Book findedBook = null;

        for (Book bookInLoop : bookList) {
            if (isbn == bookInLoop.getIsbn()){
                findedBook = bookInLoop;
            }
        }
        return findedBook;
    }

}
