
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Scanner;

public class CategoryOperations {

    public static void printCategories() {

        System.out.println();

        List<BooksCategory> booksCategoriesInPrintingMethod = CategoryData.getINSTANCE().getBooksCategories();

        for (BooksCategory categoryInLoop : booksCategoriesInPrintingMethod) {
            System.out.println(categoryInLoop.toString());

        }
        System.out.println();

    }

    public static void addCategory() {

        Scanner scanner = new Scanner(System.in);

        int newCategoryId = CategoryData.getINSTANCE().getBooksCategories().size() + 1;

        System.out.println("Please provide name of the category:");
        String newCategoryName = scanner.nextLine();
        int newCategorypriority;

        while (true) {
            System.out.println("Please provide numeric priority");
            String odp = scanner.nextLine();
            if (StringUtils.isNumeric(odp)) {
                newCategorypriority = Integer.parseInt(odp);
                break;
            }
        }
        CategoryData.getINSTANCE()
                .getBooksCategories()
                .add(new BooksCategory(newCategoryId, newCategoryName, newCategorypriority));
    }

}
