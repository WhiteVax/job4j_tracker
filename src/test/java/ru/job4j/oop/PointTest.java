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
    public void when1015to56then10dot29() {
        Point a = new Point(10, 15);
        Point b = new Point(5, 6);
        double expected = 10.29;
        double distance = a.distance(b);
        Assert.assertEquals(expected, distance, 0.01);
    }

    @Test
    public void when345to825then5dot39() {
        Point a = new Point(3, 4, 5);
        Point b = new Point(8, 2, 5);
        double expected = 5.39;
        double result = a.distance3d(b);
        Assert.assertEquals(expected, result, 0.01);
    }

    @Test
    public void when10515to8156then13dot60() {
        Point a = new Point(10, 5, 15);
        Point b = new Point(8, 15, 6);
        double expected = 13.60;
        double result = a.distance3d(b);
        Assert.assertEquals(expected, result, 0.01);
    }
}
