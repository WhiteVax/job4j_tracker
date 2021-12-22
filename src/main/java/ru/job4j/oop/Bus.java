package ru.job4j.oop;

public class Bus implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " следующая остановка ...");
    }

    @Override
    public void passengers() {
        System.out.println(getClass().getSimpleName() + " количество пассажиров 20.");
    }
}
