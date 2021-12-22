package ru.job4j.oop;

public class AirplaneAdditionally implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " взлёт через 5 минут.");
    }

    @Override
    public void passengers() {
        System.out.println(getClass().getSimpleName() + " количество занятых мест 420");
    }
}
