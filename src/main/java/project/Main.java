package project;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("file.encoding", "UTF-8");

        Map<String, Product> products = new HashMap<>();
        products.put("Bread", new Product("Bread",  50));
        products.put("Milk", new Product("Milk",  40));
        products.put("Cheese", new Product("Cheese", 30));
        products.put("Eggs", new Product("Eggs",  60));

        Store store = new Store(products);

        //4 threads
        ExecutorService executor = Executors.newFixedThreadPool(4);

        for (int i = 1; i <= 10; i++) {
            Map<String, Integer> cartItems = new HashMap<>();
            cartItems.put("Bread", 2);
            cartItems.put("Milk", 1);
            cartItems.put("Eggs", 3);

            Cart cart = new Cart(cartItems);
            executor.submit(new BuyerTask(store, cart, i));
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);

        store.printRemainingProducts();
    }
}
