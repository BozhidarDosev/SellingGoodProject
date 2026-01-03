package project;

import java.util.Map;

public class Store {

    private final Map<String, Product> products;

    public Store(Map<String, Product> products) {
        this.products = products;
    }

    public synchronized boolean sellProduct(String productName, int amount) {
        Product product = products.get(productName);

        if (product == null) {
            System.out.println("Product does not exist: " + productName);
            return false;
        }

        if (product.getQuantity() < amount) {
            System.out.println("Not enough quantity of: " + productName);
            return false;
        }

        product.decreaseQuantity(amount);
        return true;
    }

    public void printRemainingProducts() {
        System.out.println("\nRemaining quantities in store:");
        products.values().forEach(p ->
                System.out.println(p.getName() + " -> " + p.getQuantity())
        );
    }



}
