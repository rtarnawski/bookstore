import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class CategoryData {

    private static List<BooksCategory> booksCategories = new ArrayList<>();

    public List<BooksCategory> getBooksCategories() {
        return booksCategories;
    }

    private CategoryData() {
    }

    private static CategoryData INSTANCE = new CategoryData();

    public static CategoryData getINSTANCE(){

        return INSTANCE;
    }
}
