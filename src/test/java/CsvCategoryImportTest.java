import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class CsvCategoryImportTest {


    @Test(expected = FileNotFoundException.class)
    public void categoryImportFromFileShouldThrowException() throws IOException {

        CsvCategoryImport.categoryImportFromFile("categoriesy.csv");
    }

    @Test
    public void categoryImportFromFile() throws IOException {

        List<BooksCategory> expectedCategoryList = new ArrayList<>();

        expectedCategoryList.add(new BooksCategory(1, "Java", 3));
        expectedCategoryList.add(new BooksCategory(2, "Wzorce projektowe", 1));
        expectedCategoryList.add(new BooksCategory(3, "Techniki programowania", 2));

        List<BooksCategory> categoryList = CsvCategoryImport.categoryImportFromFile("src/test/resources/testCategories.csv");

        Assert.assertEquals(expectedCategoryList.size(), categoryList.size());

        Assert.assertEquals(expectedCategoryList.get(1).getName(), categoryList.get(1).getName());


    }
}