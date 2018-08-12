import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BookFunctionsTest {
    List<Book> testBookList = new ArrayList<>();
    BooksCategory testBooksCategory = new BooksCategory(1,"Science", 1);
    List<Author> testAuthorsList = Lists.newArrayList(new Author(1,"Martha", "Jane", 38));

    @Before
    public void start(){

        testBookList.add(new Book(1, "core java", 15847, 2017, BookBinding.M, testAuthorsList,testBooksCategory ));
        testBookList.add(new Book(2, "core php", 16582, 2015, BookBinding.T, testAuthorsList,testBooksCategory ));
        testBookList.add(new Book(3, "core html", 15886, 2007, BookBinding.M, testAuthorsList,testBooksCategory ));
        testBookList.add(new Book(4, "core c++", 165582, 2018, BookBinding.T, testAuthorsList,testBooksCategory ));
        testBookList.add(new Book(5, "core python", 1869558, 2018, BookBinding.M, testAuthorsList,testBooksCategory ));
    }

    @Test
    public void findBookByISBNShouldReturnProperBook() {
        int isbn = 15886;
        Book bookByISBN = BookFunctions.findBookByISBN(testBookList, isbn);
        Assert.assertEquals(isbn, bookByISBN.getIsbn());
    }

    @Test
    public void sumOfYearsOfPublishingDatesForAllBooks() {

        Assert.assertEquals(10075,BookFunctions.sumOfYearsOfPublishingDatesForAllBooks(testBookList) );
    }

    @Test
    public void sumOfBooksPublishedAfterYear() {

        Assert.assertEquals(4,BookFunctions.sumOfBooksPublishedAfterYear(testBookList, 2007));
    }


    @Test
    public void areAllPublishedAfterYear() {

        Assert.assertTrue(BookFunctions.areAllPublishedAfterYear(testBookList, 2000));
    }

    @Test
    public void getTwoLastBooks() {



        Assert.assertEquals(2, BookFunctions.getTwoLastBooks(testBookList).size());
        Assert.assertEquals(165582, BookFunctions.getTwoLastBooks(testBookList).get(0).getIsbn());
        Assert.assertEquals(1869558, BookFunctions.getTwoLastBooks(testBookList).get(1).getIsbn());

    }

    @Test
    public void getTheNewestBook() {

        Assert.assertEquals(2, BookFunctions.getTheNewestBook(testBookList).size());
        Assert.assertEquals(165582, BookFunctions.getTheNewestBook(testBookList).get(0).getIsbn());
        Assert.assertEquals(1869558, BookFunctions.getTheNewestBook(testBookList).get(1).getIsbn());

        }

    @Test
    public void getTheOldestBook() {
        Assert.assertEquals(1, BookFunctions.getTheOldestBook(testBookList).size());
        Assert.assertEquals(15886, BookFunctions.getTheOldestBook(testBookList).get(0).getIsbn());

    }
}