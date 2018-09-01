package bookstore.data;

import bookstore.pojo.BooksCategory;

import java.util.ArrayList;
import java.util.List;

public class CategoryData {
    private static CategoryData INSTANCE = new CategoryData();
    private List<BooksCategory> booksCategories = new ArrayList<>();

    private CategoryData() {
    }

    public static CategoryData getINSTANCE() {
        return INSTANCE;
    }

    public List<BooksCategory> getBooksCategories() {
        return booksCategories;
    }
}
