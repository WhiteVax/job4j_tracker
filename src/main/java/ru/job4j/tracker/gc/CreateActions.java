package ru.job4j.tracker.gc;

import ru.job4j.tracker.*;
import ru.job4j.tracker.action.UserAction;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;

public class CreateActions implements UserAction {
    private final Output out;

    public CreateActions(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Add new Item.";
    }

    @Override
    public boolean execute(Input input, Store store) {
        out.println("=== Create a new Item ===");
        String name = input.askStr("Enter name: ");
        var count = input.askInt("count");
        for (int i = 0; i < count; i++) {
            var item = new Item(name);
            store.add(item);
        }
        return true;
    }
}
