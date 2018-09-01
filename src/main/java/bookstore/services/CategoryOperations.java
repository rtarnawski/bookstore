package bookstore.services;

import bookstore.utils.Validator;
import bookstore.data.CategoryData;
import bookstore.utils.UserInput;
import lombok.extern.slf4j.Slf4j;
import bookstore.pojo.BooksCategory;

import java.util.List;

@Slf4j
public class CategoryOperations {
    public static void changeCategoryName(List<BooksCategory> categoryList) {
        BooksCategory categoryByIdFromUser = findCategoryByIdFromUser(categoryList);
        System.out.println("Provide new name for this category");
        String newName = Validator.alphaValidator(UserInput.scanner.nextLine());
        categoryByIdFromUser.setName(newName);
        System.out.println("New title: " + newName + " has been set\n");
    }

    public static void printCategories() {
        System.out.println();
        for (BooksCategory categoryInLoop : CategoryData.getINSTANCE().getBooksCategories()) {
            System.out.println(categoryInLoop.toString());
        }
        System.out.println();
        log.info("Print Categories");
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

    public static BooksCategory findCategoryByIdFromUser(List<BooksCategory> categoryList) {
        System.out.println("\nPlease provide ID of category\n");
        for (BooksCategory category : categoryList) {
            System.out.println("ID: " + category.getCategoryID() + "  ----   " + category.getName());
        }
        System.out.println();
        int categoryId = Integer.parseInt(Validator.numericValidator(UserInput.scanner.nextLine()));
        for (BooksCategory category : categoryList) {
            if (category.getCategoryID() == categoryId) {
                return category;
            }
        }
        System.out.println("Category not found");
        return findCategoryByIdFromUser(categoryList);
    }
}
