package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.StubInput;
import ru.job4j.tracker.input.ValidateInput;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.StubOutput;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ValidateInputTest {

    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"one", "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenInvalidInputs() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"1", "2", "3", "4", "5", "6"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int[] selected = {input.askInt("Enter menu:"),
                input.askInt("Enter menu:"),
                input.askInt("Enter menu:"),
                input.askInt("Enter menu:"),
                input.askInt("Enter menu:"),
                input.askInt("Enter menu:")};
        int[] expected = {1, 2, 3, 4, 5, 6};
        assertThat(selected, is(expected));
    }

    @Test
    public void whenNotInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"-1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(-1));
    }
}
