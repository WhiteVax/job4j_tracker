package ru.job4j.tracker;

public class ExionAction implements UserAction {
    @Override
    public String name() {
        return "Exit.";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        return false;
    }
}
