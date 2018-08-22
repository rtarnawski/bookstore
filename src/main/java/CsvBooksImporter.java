import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvBooksImporter {
    public static List<Book> bookImportFromFile(String filename) throws IOException {
        List<Book> bookList = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
            String nextLine = bufferedReader.readLine();
            while (nextLine != null) {
                String[] split = nextLine.split(";");
                int id = Integer.parseInt(split[0]);
                String title = split[1];
                int isbn = Integer.parseInt(split[2]);
                int publishingDate = Integer.parseInt(split[3]);
                BookBinding bookBinding = (BookBinding.valueOf(split[4]));
                List<Author> authorList = new ArrayList<>();
                String[] authorsSplitted = split[5].split(",");
                for (String s : authorsSplitted) {
                    int idAuthor = Integer.parseInt(s);
                    List<Author> authorsInImport = AuthorData.getINSTANCE().getAuthors();
                    for (int i = 0; i < authorsInImport.size(); i++) {
                        if (idAuthor == authorsInImport.get(i).getAuthorID()) {
                            authorList.add(authorsInImport.get(i));
                        }
                    }
                }
                int categoryId = Integer.parseInt(split[6]);
                BooksCategory category = null;
                List<BooksCategory> booksCategoriesInImport = CategoryData.getINSTANCE().getBooksCategories();
                for (int i = 0; i < booksCategoriesInImport.size(); i++) {
                    if (categoryId == booksCategoriesInImport.get(i).getCategoryID()) {
                        category = booksCategoriesInImport.get(i);
                    }
                }
                bookList.add(new Book(id, title, isbn, publishingDate, bookBinding, authorList, category));
                nextLine = bufferedReader.readLine();
            }
        }
        return bookList;
    }
}
