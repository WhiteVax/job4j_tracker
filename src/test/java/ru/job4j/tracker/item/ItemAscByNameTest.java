package ru.job4j.tracker.item;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import ru.job4j.tracker.Item;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ItemAscByNameTest {

    @Test
    public void sortAscByName() {
        List<Item> items = new ArrayList<>(List.of(
                new Item("Yuri", 3),
                new Item("Dmitry", 2),
                new Item("Arsen", 1)
        ));
        Collections.sort(items, new ItemAscByName());
        List<Item> expect = new ArrayList<>(List.of(
                new Item("Arsen", 1),
                new Item("Dmitry", 2),
                new Item("Yuri", 3)
        ));
        assertThat(items, is(expect));
    }
}

