package project;

public class BuyerTask implements Runnable {

    private final Store store;
    private final Cart cart;
    private final int buyerId;

    public BuyerTask(Store store, Cart cart, int buyerId) {
        this.store = store;
        this.cart = cart;
        this.buyerId = buyerId;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();

        System.out.println("Buyer " + buyerId +
                " started shopping on thread: " + threadName);

        cart.getItems().forEach((product, quantity) -> {
            boolean success = store.sellProduct(product, quantity);
            if (success) {
                System.out.println("Buyer " + buyerId +
                        " bought " + quantity + " of " + product +
                        " on thread: " + threadName);
            }
        });

        System.out.println("Buyer " + buyerId +
                " finished shopping on thread: " + threadName);
    }
}
