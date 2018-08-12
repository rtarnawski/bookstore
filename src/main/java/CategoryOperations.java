import java.util.List;

public class CategoryOperations {

    public static void printCategories(){

        System.out.println();

        List<BooksCategory> booksCategoriesInPrintingMethod = CategoryData.getINSTANCE().getBooksCategories();

        for (BooksCategory categoryInLoop : booksCategoriesInPrintingMethod) {
            System.out.println(categoryInLoop.toString());

        }
        System.out.println();

    }
}
