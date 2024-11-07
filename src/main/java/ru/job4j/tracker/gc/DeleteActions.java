package ru.job4j.tracker.gc;

import ru.job4j.tracker.*;
import ru.job4j.tracker.action.UserAction;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;

import java.util.List;

public class DeleteActions implements UserAction {
    private final Output out;

    public DeleteActions(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete item.";
    }

    @Override
    public boolean execute(Input input, Store store) {
        out.println("=== Delete items ===");
        int id = input.askInt("Enter count: ");
        List<Item> ids = store.findAll();
        for (int i = 0; i < id; i++) {
            if (store.delete(ids.get(i).getId())) {
                out.println("Заявка удалена успешно.");
            } else {
                out.println("Ошибка удаления заявки.");
            }
        }
        return true;
    }
}
