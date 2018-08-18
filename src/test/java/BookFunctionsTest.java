import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class BookFunctionsTest {
    List<Book> testBookList = new ArrayList<>();
    BooksCategory testBooksCategory = new BooksCategory(1, "Science", 1);
    List<Author> testAuthorsList = Lists.newArrayList(new Author(1, "Martha", "Jane", 38));

    @Before
    public void start() {

        testBookList.add(new Book(1, "core java", 15847, 2017, BookBinding.M, testAuthorsList, testBooksCategory));
        testBookList.add(new Book(2, "core php", 16582, 2015, BookBinding.T, testAuthorsList, testBooksCategory));
        testBookList.add(new Book(3, "core html", 15886, 2007, BookBinding.M, testAuthorsList, testBooksCategory));
        testBookList.add(new Book(4, "core c++", 165582, 2018, BookBinding.T, testAuthorsList, testBooksCategory));
        testBookList.add(new Book(5, "core python", 1869558, 2018, BookBinding.M, testAuthorsList, testBooksCategory));
    }

    @Test
    public void findBookByISBNShouldReturnProperBook() {
        int isbn = 15886;
        Book bookByISBN = BookFunctions.findBookByISBN(testBookList, isbn);
        Assert.assertEquals(isbn, bookByISBN.getIsbn());
    }

    @Test
    public void findBookByISBNShouldReturnProperBookStreamStyle() {
        int isbn = 15886;
        Book bookByISBN = BookFunctions.findBookByISBNStreamStyle(testBookList, isbn);
        Assert.assertEquals(isbn, bookByISBN.getIsbn());
    }

    @Test
    public void sumOfYearsOfPublishingDatesForAllBooks() {

        Assert.assertEquals(10075, BookFunctions.sumOfYearsOfPublishingDatesForAllBooks(testBookList));
    }

    @Test
    public void sumOfYearsOfPublishingDatesForAllBooksStreamStyle() {

        Assert.assertEquals(10075, BookFunctions.sumOfYearsOfPublishingDatesForAllBooksStreamStyle(testBookList));
    }


    @Test
    public void sumOfBooksPublishedAfterYear() {

        Assert.assertEquals(4, BookFunctions.sumOfBooksPublishedAfterYear(testBookList, 2007));
    }

    @Test
    public void sumOfBooksPublishedAfterYearStreamStyle() {

        Assert.assertEquals(4, BookFunctions.sumOfBooksPublishedAfterYearStreamStyle(testBookList, 2007));
    }

    @Test
    public void areAllPublishedAfterYear() {

        Assert.assertTrue(BookFunctions.areAllPublishedAfterYear(testBookList, 2000));
    }

    @Test
    public void areAllPublishedAfterYearStreamStyle() {

        Assert.assertTrue(BookFunctions.areAllPublishedAfterYearStreamStyle(testBookList, 2000));
    }

    @Test
    public void getTwoLastBooks() {

        Assert.assertEquals(2, BookFunctions.getTwoLastBooks(testBookList).size());
        Assert.assertEquals(165582, BookFunctions.getTwoLastBooks(testBookList).get(0).getIsbn());
        Assert.assertEquals(1869558, BookFunctions.getTwoLastBooks(testBookList).get(1).getIsbn());
    }

    @Test
    public void getTwoLastBooksStreamStyle() {

        Assert.assertEquals(2, BookFunctions.getTwoLastBooksSteamStyle(testBookList).size());
        Assert.assertEquals(165582, BookFunctions.getTwoLastBooksSteamStyle(testBookList).get(0).getIsbn());
        Assert.assertEquals(1869558, BookFunctions.getTwoLastBooksSteamStyle(testBookList).get(1).getIsbn());
    }

    @Test
    public void getTheNewestBook() {

        Assert.assertEquals(2, BookFunctions.getTheNewestBook(testBookList).size());
        Assert.assertEquals(165582, BookFunctions.getTheNewestBook(testBookList).get(0).getIsbn());
        Assert.assertEquals(1869558, BookFunctions.getTheNewestBook(testBookList).get(1).getIsbn());

    }

    @Test
    public void getTheNewestBookStreamStyle() {
        Assert.assertEquals(165582, BookFunctions.getTheNewestBookStreamStyle(testBookList).getIsbn());

    }

    @Test
    public void getTheOldestBook() {
        Assert.assertEquals(1, BookFunctions.getTheOldestBook(testBookList).size());
        Assert.assertEquals(15886, BookFunctions.getTheOldestBook(testBookList).get(0).getIsbn());
    }


    @Test
    public void getTheOldestBookStreamStyle() {
        Assert.assertEquals(15886, BookFunctions.getTheOldestBookStreamStyle(testBookList).getIsbn());
    }

    @Test
    public void getAveragePublishingYear() {
        Assert.assertEquals(2015, BookFunctions.getAveragePublishingYear(testBookList));
    }

    @Test
    public void getAveragePublishingYearStreamStyle() {
        Assert.assertEquals(2015, BookFunctions.getAveragePublishingYearStreamStyle(testBookList));
    }


    @Test
    public void bookPublishedBefore() {
        Assert.assertFalse(BookFunctions.bookPublishedBefore(2003, testBookList));
        Assert.assertTrue(BookFunctions.bookPublishedBefore(2015, testBookList));
    }


    @Test
    public void bookPublishedBeforeStremStyle() {
        Assert.assertFalse(BookFunctions.bookPublishedBeforeStreamStyle(2003, testBookList));
        Assert.assertTrue(BookFunctions.bookPublishedBeforeStreamStyle(2015, testBookList));
    }

    @Test
    public void booksPublishedAfterYearWithTitleBeginigWitLetter() {

        Assert.assertEquals(4, BookFunctions.booksPublishedAfterYearWithTitleBeginigWitLetter(2010, "c", testBookList).size());
        Assert.assertEquals(4, BookFunctions.booksPublishedAfterYearWithTitleBeginigWitLetter(2010, "C", testBookList).size());
    }


    @Test
    public void booksPublishedAfterYearWithTitleBeginigWitLetterStreamStyle() {

        Assert.assertEquals(4, BookFunctions.booksPublishedAfterYearWithTitleBeginigWitLetterStreamStyle(2010, "c", testBookList).size());
        Assert.assertEquals(4, BookFunctions.booksPublishedAfterYearWithTitleBeginigWitLetterStreamStyle(2010, "C", testBookList).size());
    }

    @Test
    public void sortBooksAsscendingByPublishingDate() {

        Assert.assertEquals(15886, BookFunctions.sortBooksAsscendingByPublishingDate(testBookList).get(0).getIsbn());
        Assert.assertEquals(1869558, BookFunctions.sortBooksAsscendingByPublishingDate(testBookList).get(testBookList.size() - 1).getIsbn());
    }

    @Test
    public void sortBooksAsscendingByPublishingDateStremStyle() {
        Assert.assertEquals(15886, BookFunctions.sortBooksAsscendingByPublishingDateStreamStyle(testBookList).get(0).getIsbn());
        Assert.assertEquals(1869558, BookFunctions.sortBooksAsscendingByPublishingDateStreamStyle(testBookList).get(testBookList.size() - 1).getIsbn());
    }

    @Test
    public void sortBooksDescendingByPublishingDate() {

        Assert.assertEquals(1869558, BookFunctions.sortBooksDescendingByPublishingDate(testBookList).get(0).getIsbn());
        Assert.assertEquals(15886, BookFunctions.sortBooksDescendingByPublishingDate(testBookList).get(testBookList.size() - 1).getIsbn());
    }


    @Test
    public void sortBooksDescendingByPublishingDateStreamStyle() {

        Assert.assertEquals(2018, BookFunctions.sortBooksDescendingByPublishingDateStreamStyle(testBookList).get(0).getPublishingDate());
        Assert.assertEquals(2007, BookFunctions.sortBooksDescendingByPublishingDateStreamStyle(testBookList).get(testBookList.size() - 1).getPublishingDate());
    }
}