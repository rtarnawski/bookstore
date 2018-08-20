import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvCategoryExporter {
    public static void exportCategoriesToCsvFile(List<BooksCategory> categoryList) {
        try (FileWriter writer = new FileWriter(new File("categories.csv"))) {
            StringBuilder stringBuilder = new StringBuilder();
            for (BooksCategory category : categoryList) {
                stringBuilder.append(category.getCategoryID());
                stringBuilder.append(";");
                stringBuilder.append(category.getName());
                stringBuilder.append(";");
                stringBuilder.append(category.getPriority());
                stringBuilder.append("\n");
            }
            writer.write(stringBuilder.toString().trim());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}