import java.util.List;

public class CategoryOperations {
    public static void printCategories() {
        System.out.println();
        for (BooksCategory categoryInLoop : CategoryData.getINSTANCE().getBooksCategories()) {
            System.out.println(categoryInLoop.toString());
        }
        System.out.println();
    }

    public static void addCategory() {
        int newCategoryId = CategoryData.getINSTANCE().getBooksCategories().size() + 1;
        System.out.println("Please provide name of the category:");
        String newCategoryName = Validator.alphaValidator(UserInput.scanner.nextLine());
        System.out.println("Please provide numeric priority");
        int newCategoryPriority = Integer.parseInt(Validator.numericValidator(UserInput.scanner.nextLine()));
        CategoryData.getINSTANCE()
                .getBooksCategories()
                .add(new BooksCategory(newCategoryId, newCategoryName, newCategoryPriority));
        System.out.println("Thank you. Category " + newCategoryName + " has been added");
    }

    public static BooksCategory findCategoryById(List<BooksCategory> categoryList, int categoryId) {
        for (BooksCategory category : categoryList) {
            if (category.getCategoryID() == categoryId) {
                return category;
            }
        }
        return null;
    }
}
