package ru.job4j.poly;

public class Bus implements Transport {

    @Override
    public void run() {
    }

    @Override
    public void passengers(int passengers) {
    }

    @Override
    public double refuel(double refuel) {
        return refuel * 43.40;
    }
}
