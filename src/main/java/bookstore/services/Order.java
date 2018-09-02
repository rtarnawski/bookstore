package bookstore.services;

import bookstore.pojo.Book;
import bookstore.pojo.BookBinding;

import java.util.List;
import java.util.Optional;

public class Order {
    public static void orderBookForRePrinting(List<Book> books) {
        Optional<Book> bookById = BookOperations.findBookById(books);
        if (bookById.isPresent()) {
            Book bookForOrder = bookById.get();
            OrderReprint reprint;
            if (bookForOrder.getBookBinding().equals(BookBinding.T)) {
                reprint = new OrderHardCover();
                reprint.orderReprint();
            } else {
                reprint = new OrderSoftCover();
                reprint.orderReprint();
            }
        }
    }
}
