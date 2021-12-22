package ru.job4j.oop;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " остановка продлится 20 минут.");
    }

    @Override
    public void passengers() {
        System.out.println(getClass().getSimpleName() + " занято 45 спальных места.");
    }
}
