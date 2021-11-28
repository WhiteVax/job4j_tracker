package ru.job4j.condition;

import org.junit.Test;
import org.junit.Assert;

public class MaxTest {
    @Test
    public void whenMax7to2then7() {
        int first = 7;
        int second = 2;
        int expected = 7;
        Max max = new Max();
        int result = max.max(first, second);
        Assert.assertEquals(result, expected);
    }

    @Test
    public void whenMax2to10to4to25then25() {
        int first = 2;
        int second = 10;
        int third = 4;
        int fourth = 25;
        int expected = 25;
        Max max = new Max();
        int result = max.max(first, second, third, fourth);
        Assert.assertEquals(expected, result);
    }
}

