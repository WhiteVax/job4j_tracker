package ru.job4j.tracker.gc;

import ru.job4j.tracker.*;

import java.util.List;

public class Start {

        private final Output out;

        public Start(Output out) {
            this.out = out;
        }

        public void init(Input input, Store memTracker, List<UserAction> actions) {
            var run = true;
            while (run) {
                this.showMenu(actions);
                var select = input.askInt("Select: ");
                if (select < 0 || select >= actions.size()) {
                    out.println("Wrong input, you can select: 0 .. " + (actions.size() - 1));
                    continue;
                }
                var action = actions.get(select);
                run = action.execute(input, memTracker);
            }
        }

        private void showMenu(List<UserAction> actions) {
            out.println("Menu:");
            for (int i = 0; i < actions.size(); i++) {
                out.println(i + ". " + actions.get(i).name());
            }
        }

        public static void main(String[] args) {
            var output = new ConsoleOutput();
            var input = new ValidateInput(output, new ConsoleInput());
            var tracker = new SqlTracker();
                tracker.init();
                List<UserAction> actions = List.of(
                        new CreateActions(output),
                        new ShowAllAction(output),
                        new EditAction(output),
                        new DeleteAction(output),
                        new FindActionById(output),
                        new FindActionByName(output),
                        new ExitAction(output)
                );
                new Start(output).init(input, tracker, actions);
        }
    }

