package ru.job4j.oop;

public class TrainAdditionally implements Vehicle {

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " следующая станция ...");
    }

    @Override
    public void passengers() {
        System.out.println(getClass().getSimpleName() + " занято 50 спальных места.");
    }
}
