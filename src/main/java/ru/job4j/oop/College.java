package ru.job4j.oop;

public class College {
    public static void main(String[] args) {
        Freshman newStudent = new Freshman();
        Student fromFresman = newStudent;
        Object fromStudent = fromFresman;
    }
}
