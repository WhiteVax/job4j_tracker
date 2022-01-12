package ru.job4j.tracker;

public class SingleTracker {
    private Tracker tracker = new Tracker();
    private static SingleTracker inctance = null;

    private SingleTracker() {
    }

    public static SingleTracker getInstance() {
        if (inctance == null) {
            inctance = new SingleTracker();
        }
        return getInstance();
    }

    public Item add(Item item) {
        return tracker.add(item);
    }

    public Item findById(int id) {
        return tracker.findById(id);
    }

    public Item[] findByName(String name) {
        return tracker.findByName(name);
    }

    public Item[] findByAllItems() {
        return tracker.findAll();
    }

    public boolean editItem(int id, Item item) {
        return tracker.replace(id, item);
    }

    public boolean deleteItem(int id) {
        return tracker.delete(id);
    }
}
