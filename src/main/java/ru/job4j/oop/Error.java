package ru.job4j.oop;

public class Error {

    private boolean active;

    private int stutas;

    private String message;

    public void printInfo() {
        System.out.println("Активность: " + active);
        System.out.println("Статус: " + stutas);
        System.out.println("Сообщение: " + message);
    }

    public Error() {
    }

    public Error(boolean active, int stutas, String message) {
        this.active = active;
        this.stutas = stutas;
        this.message = message;
    }

    public static void main(String[] args) {
        Error error = new Error(true, 10, "найден");
        error.printInfo();

        Error error404 = new Error(false, 0, "ненайден");
        error404.printInfo();
    }
}
