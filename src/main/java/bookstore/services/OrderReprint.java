package bookstore.services;

public abstract class OrderReprint {
    public void orderReprint() {
        startOfOrder();
        orderForPrintRoom();
        endOfOrder();
        replyFromPrintRoom();
    }

    public void startOfOrder() {
        System.out.println("\nYour order for reprinting is starting....");
    }

    abstract void orderForPrintRoom();

    public void endOfOrder() {
        System.out.println("Your order is placed");
    }

    abstract void replyFromPrintRoom();
}
