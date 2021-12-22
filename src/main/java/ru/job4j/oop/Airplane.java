package ru.job4j.oop;

public class Airplane implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " дозаправка продлится 20 минут.");
    }

    @Override
    public void passengers() {
        System.out.println(getClass().getSimpleName() + " количество посадочных мест 420");
    }
}
