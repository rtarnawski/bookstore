import org.junit.Assert;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BookFunctionsTest {



    List<Book> testBookList = new ArrayList<>();

    @BeforeAll
  void start(){

        List<Author> testAuthorsList = new ArrayList<>();
        testAuthorsList.add(new Author(1,"Martha", "Jane", 38) );

        BooksCategory testBooksCategory = new BooksCategory(1,"Science", 1);


        testBookList.add(new Book(1, "core java", 15847, 2017, BookBinding.M, testAuthorsList,testBooksCategory ));
        testBookList.add(new Book(2, "core php", 16582, 2015, BookBinding.T, testAuthorsList,testBooksCategory ));
        testBookList.add(new Book(3, "core html", 15886, 2007, BookBinding.M, testAuthorsList,testBooksCategory ));
        testBookList.add(new Book(4, "core c++", 165582, 2005, BookBinding.T, testAuthorsList,testBooksCategory ));
        testBookList.add(new Book(5, "core python", 1869558, 2018, BookBinding.M, testAuthorsList,testBooksCategory ));
    }


    @Test
    void findBookByISBNShouldReturnProperBook() {
        int isbn = 15886;

        Book bookByISBN = BookFunctions.findBookByISBN(testBookList, isbn);

        Assert.assertEquals(isbn, bookByISBN.getIsbn());

    }
}