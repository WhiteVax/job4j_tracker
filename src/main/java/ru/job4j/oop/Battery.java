package ru.job4j.oop;

public class Battery {

    private int load;

    public int getLoad() {
        return load;
    }

    public Battery(int load) {
        this.load = load;
    }

    public void exchange(Battery another) {
       another.load = another.load + getLoad();
       this.load = 0;
    }
}
