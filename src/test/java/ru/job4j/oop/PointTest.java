package ru.job4j.oop;

import org.junit.Test;
import org.junit.Assert;

public class PointTest {

    @Test
    public void when00to20then2() {
        Point a = new Point(0, 0);
        Point b = new Point(2, 0);
        double distance = a.distance(b);
        double expected = 2;
        Assert.assertEquals(expected, distance, 0.01);
    }

    @Test
    public void when44to44then0() {
        Point a = new Point(4, 4);
        Point b = new Point(4, 4);
        double expected = 0;
        double distance = a.distance(b);
        Assert.assertEquals(expected, distance, 0.01);
    }

    @Test
    public void when1015to56then1029() {
        Point a = new Point(10, 15);
        Point b = new Point(5, 6);
        double expected = 10.29;
        double distance = a.distance(b);
        Assert.assertEquals(expected, distance, 0.01);
    }
}
