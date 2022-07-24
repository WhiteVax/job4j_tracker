package ru.job4j.inheritance;

public class PizzaExtraCheese extends Pizza{
    @Override
    public String name() {
        return String.format("%s + extra cheese", super.name());
    }
}
