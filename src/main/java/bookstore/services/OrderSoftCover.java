package bookstore.services;

public class OrderSoftCover extends OrderReprint {
    @Override
    public void orderForPrintRoom() {
        System.out.println("Printing house will print book with soft cover");
    }

    @Override
    public void replyFromPrintRoom() {
        System.out.println("We will deliver your book with soft cover shortly\n");
    }
}
