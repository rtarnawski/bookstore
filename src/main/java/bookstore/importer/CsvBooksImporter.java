package bookstore.importer;

import bookstore.data.AuthorData;
import bookstore.services.AuthorOperations;
import bookstore.data.CategoryData;
import bookstore.services.CategoryOperations;
import bookstore.pojo.Author;
import bookstore.pojo.Book;
import bookstore.pojo.BookBinding;
import bookstore.pojo.BooksCategory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CsvBooksImporter {
    public static List<Book> bookImportFromFile(String filename) throws IOException, NumberFormatException {
        List<Book> bookList = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
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
            authorSetting(authorList, authorsSplitted);
            int categoryId = Integer.parseInt(split[6]);
            BooksCategory category = CategoryOperations.findCategoryById(CategoryData.getINSTANCE().getBooksCategories(), categoryId);
            bookList.add(new Book(id, title, isbn, publishingDate, bookBinding, authorList, category));
            nextLine = bufferedReader.readLine();
        }
        bufferedReader.close();
        return bookList;
    }

    public static void authorSetting(List<Author> authorList, String[] authorsSplitted) {
        for (String authorId : authorsSplitted) {
            int idAuthor = Integer.parseInt(authorId);
            Optional<Author> authorById = AuthorOperations.findAuthorById(AuthorData.getINSTANCE().getAuthors(), idAuthor);
            if (authorById.isPresent()) {
                authorList.add(authorById.get());
            }
        }
    }
}
