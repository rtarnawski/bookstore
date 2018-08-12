import org.junit.Assert;
        import org.junit.Test;


        import java.io.BufferedReader;
        import java.io.FileNotFoundException;
        import java.io.FileReader;
        import java.io.IOException;
        import java.util.ArrayList;
        import java.util.Arrays;
        import java.util.List;
        import java.util.Objects;

        import static org.junit.Assert.*;


public class CsvCategoryImportTest {


    @Test(expected = FileNotFoundException.class)
    public void categoryImportFromFileShouldThrowException() throws IOException {

       CsvCategoryImport.categoryImportFromFile("categoriesy.csv");

    }

    @Test
    public void categoryImportFromFile() throws IOException {



        List<BooksCategory> expectedCategoryList = new ArrayList<>();

        expectedCategoryList.add(new BooksCategory(1,"Java",3));
        expectedCategoryList.add(new BooksCategory(2,"Wzorce projektowe",1));
        expectedCategoryList.add(new BooksCategory(3,"Techniki programowania",2));

        List<BooksCategory> categoryList = CsvCategoryImport.categoryImportFromFile("categories.csv");

        Assert.assertEquals(expectedCategoryList.size(), categoryList.size());

        Assert.assertEquals(expectedCategoryList.get(1).getName(), categoryList.get(1).getName());


       // Assertions.assertEquals(expectedCategoryList.toArray(), categoryList.toArray());
//       Assert.assertArrayEquals(expectedCategoryList.toArray(), categoryList.toArray());
//       assertTrue(Arrays.equals(expectedCategoryList.toArray(), categoryList.toArray()));

    }
}