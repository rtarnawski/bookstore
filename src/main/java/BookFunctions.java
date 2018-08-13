import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookFunctions {

    public static Book findBookByISBN(List<Book> bookList, int isbn){

            for (Book bookInLoop : bookList) {
            if (isbn == bookInLoop.getIsbn()){
                return bookInLoop;
            }
        }
        return null;
    }

    // StreamStyle

    public static Book findBookByISBNStreamStyle(List<Book> bookList, int isbn){

        return bookList.stream().filter(e -> e.getIsbn() == isbn).findFirst().get();
    }



public static long sumOfYearsOfPublishingDatesForAllBooks(List<Book> bookList){
        long sum = 0;
    for (Book bookInLoop : bookList) {
        sum += bookInLoop.getPublishingDate();
    }
        return sum;
}

public static int sumOfBooksPublishedAfterYear(List<Book>bookList, int year){

        int sum = 0;
    for (Book bookInLoop : bookList) {
        if (bookInLoop.getPublishingDate() > year){
            sum+=1;
        }
    }
        return sum;
}

public static boolean areAllPublishedAfterYear(List<Book> bookList, int year){

    for (Book bookInLoop : bookList) {
        if (bookInLoop.getPublishingDate() <= year)
        return false;
    }
        return true;
}

public static List<Book> getTwoLastBooks(List<Book> bookList){
        List<Book> twoLastBooks = new ArrayList<>();

    for (int i = bookList.size()-2; i < bookList.size(); i++) {
        twoLastBooks.add(bookList.get(i));
    }
    return twoLastBooks;

}


public static List<Book> getTheNewestBook(List<Book> bookList){

        List<Book> theNewestBooks = new ArrayList<>();

        int highYear = 0;

    for (Book bookInLoop : bookList) {

        if (bookInLoop.getPublishingDate() > highYear){
            theNewestBooks.clear();
            theNewestBooks.add(bookInLoop);

            highYear = bookInLoop.getPublishingDate();
        } else if(bookInLoop.getPublishingDate() == highYear){
            theNewestBooks.add(bookInLoop);
        }

    }
return theNewestBooks;

}

    public static List<Book> getTheOldestBook(List<Book> bookList){

        List<Book> theOldestBooks = new ArrayList<>();

        int lowYear = Integer.MAX_VALUE;

        for (Book bookInLoop : bookList) {

            if (bookInLoop.getPublishingDate() < lowYear){
                theOldestBooks.clear();
                theOldestBooks.add(bookInLoop);

                lowYear = bookInLoop.getPublishingDate();
            } else if(bookInLoop.getPublishingDate() == lowYear){
                theOldestBooks.add(bookInLoop);
            }

        }
        return theOldestBooks;

    }

}
