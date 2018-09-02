package bookstore.services;

public class OrderHardCover extends OrderReprint {
    @Override
    void orderForPrintRoom() {
        System.out.println("Printing house will print book with HARD cover");
    }

    @Override
    void replyFromPrintRoom() {
        System.out.println("We will deliver your book with HARD cover shortly\n");
    }
}
