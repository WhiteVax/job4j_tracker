package ru.job4j.checkstyle;

public class Broken {
    static final String NEW_VALUE = "";
    private int sizeOfEmpty = 10;
    private String surname;
    private String name;

    public Broken() {
    }

    public void echo() {
    }

    public void media(Object obj) {
        if (obj != null) {
            System.out.println(obj);
        }
    }

    public void method(int a, int b, int c, int d) {
        System.out.println(a + b + c + d);
    }

    public void methodSecond(int e, int f, int g, int h) {
        System.out.println(e + f + g + h);
    }
}
