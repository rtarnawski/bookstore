import com.google.common.collect.Lists;

import java.util.*;

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

    public static long sumOfYearsOfPublishingDatesForAllBooksStreamStyle(List<Book> bookList){

        return bookList.stream().mapToLong(Book::getPublishingDate).sum();

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

    public static int getAveragePublishingYear(List<Book> bookList){

        int sumOfPublishingYears = 0;

        for (Book book : bookList) {

            sumOfPublishingYears += book.getPublishingDate();
        }
        return sumOfPublishingYears / bookList.size();
    }

    public static boolean bookPublishedBefore(int year, List<Book> bookList){

        for (Book book : bookList) {
            if ((book.getPublishingDate() < year))
                return true;
        }
        return false;
    }

    public static List<Book> booksPublishedAfterYearWithTitleBeginigWitLetter(int year, String letter, List<Book> bookList){
        List<Book> resultBookList = new ArrayList<>();
        for (Book bookInLoop : bookList) {
            String firstLetterInLoop = bookInLoop.getTitle().substring(0, 1);

            // I decided to extract first letter to be able to use .equalsIgnorcase instead of
            // .startsWith(letter), which is case sensitive


            if (bookInLoop.getPublishingDate() > year && firstLetterInLoop.equalsIgnoreCase(letter)){
                    resultBookList.add(bookInLoop);
            }
        }
        return resultBookList;
    }

    static class BookCompAscPublishingDate implements Comparator<Book>{
        @Override
        public int compare(Book o1, Book o2) {
            if (o1.getPublishingDate() < o2.getPublishingDate()){
                return -1;
            }
            return 1;
        }
    }



    public static List<Book> sortBooksAsscendingByPublishingDate(List<Book> bookList){

     Collections.sort(bookList, new BookCompAscPublishingDate());

     return bookList;

    }


    public static List<Book> sortBooksDescendingByPublishingDate(List<Book> bookList){

        Collections.sort(bookList, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {

                if (o1.getPublishingDate() < o2.getPublishingDate()){
                    return 1;
                }
                return -1;
            }
        });

        return bookList;
    }

}
