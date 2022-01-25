package ru.job4j.tracker;

import java.util.ArrayList;

public class SingleTracker {
    private Tracker tracker = new Tracker();
    private static SingleTracker instance = null;

    private SingleTracker() {
    }

    public static SingleTracker getInstance() {
        if (instance == null) {
            instance = new SingleTracker();
        }
        return getInstance();
    }

    public Item add(Item item) {
        return tracker.add(item);
    }

    public Item findById(int id) {
        return tracker.findById(id);
    }

    public ArrayList<Item> findByName(String name) {
        return tracker.findByName(name);
    }

    public ArrayList<Item> findByAllItems() {
        return tracker.findAll();
    }

    public boolean editItem(int id, Item item) {
        return tracker.replace(id, item);
    }

    public boolean deleteItem(int id) {
        return tracker.delete(id);
    }
}
