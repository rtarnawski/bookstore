import org.junit.Assert;
        import org.junit.Test;
        import org.junit.jupiter.api.Assertions;


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

    @Test
    public void categoryImportFromFile() {



        List<BooksCategory> expectedCategoryList = new ArrayList<>();

        expectedCategoryList.add(new BooksCategory(1,"Java",3));
        expectedCategoryList.add(new BooksCategory(2,"Wzorce projektowe",1));
        expectedCategoryList.add(new BooksCategory(3,"Techniki programowania",2));

        List<BooksCategory> categoryList = CsvCategoryImport.categoryImportFromFile("categories.csv");

        Assertions.assertEquals(expectedCategoryList.size(), categoryList.size());

        Assertions.assertEquals(expectedCategoryList.get(1).getName(), categoryList.get(1).getName());


       // Assertions.assertEquals(expectedCategoryList.toArray(), categoryList.toArray());
//       Assert.assertArrayEquals(expectedCategoryList.toArray(), categoryList.toArray());
//       assertTrue(Arrays.equals(expectedCategoryList.toArray(), categoryList.toArray()));

    }
}