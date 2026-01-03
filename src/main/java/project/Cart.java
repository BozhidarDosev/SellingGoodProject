package project;

import java.util.Map;

public class Cart {
    private final Map<String, Integer> items;

    public Cart(Map<String, Integer> items) {
        this.items = items;
    }

    public Map<String, Integer> getItems() {
        return items;
    }
}
