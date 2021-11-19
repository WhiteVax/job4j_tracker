package ru.job4j.oop;

public class Cat {

    private  String food;

    private String name;

    public void eat(String meat) {
        this.food = meat;
    }

    public void getNick(String nick) {
        this.name = nick;
    }

    public void show() {
        System.out.println("The cat name is " + this.name);
        System.out.println("The cat ate " + this.food);
    }

    public static void main(String[] args) {
        Cat sparky = new Cat();
        sparky.eat("fish");
        sparky.getNick("sparky");
        sparky.show();
    }
}
