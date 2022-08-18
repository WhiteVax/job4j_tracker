package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class SingleTracker {
    private MemTracker memTracker = new MemTracker();
    private static SingleTracker instance = null;
    private final List<Item> items = new ArrayList<>();

    private SingleTracker() {
    }

    public static SingleTracker getInstance() {
        if (instance == null) {
            instance = new SingleTracker();
        }
        return getInstance();
    }

    public Item add(Item item) {
        return memTracker.add(item);
    }

    public Item findById(int id) {
        return memTracker.findById(id);
    }

    public List<Item> findByName(String name) {
        return memTracker.findByName(name);
    }

    public List<Item> findByAllItems() {
        return List.copyOf(items);
    }

    public boolean editItem(int id, Item item) {
        return memTracker.replace(id, item);
    }

    public boolean deleteItem(int id) {
        return memTracker.delete(id);
    }
}
