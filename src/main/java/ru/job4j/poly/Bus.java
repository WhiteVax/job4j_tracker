package ru.job4j.poly;

public class Bus implements Transport {

    @Override
    public void run() {
        boolean run = true;
    }

    @Override
    public void passengers(int passengers) {
        int count = passengers;
    }

    @Override
    public double refuel(double refuel) {
        double price = 43.50;
        return refuel * price;
    }
}
