package ru.job4j.tracker.item;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import ru.job4j.tracker.Item;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ItemAscByNameTest {

    @Test
    public void sortByName() {
        List<Item> items = new ArrayList<>(List.of(
                new Item("Yuri", 2),
                new Item("Dmitry", 2),
                new Item("Arsen", 1)
        ));
        items.sort(new ItemAscByName());
        List<Item> expect = List.of(
                new Item("Arsen", 1),
                new Item("Dmitry", 2),
                new Item("Yuri", 2)
        );
        assertThat(items, is(expect));
    }
}
