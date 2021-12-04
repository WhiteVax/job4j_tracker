package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartUI extends Item {

    public StartUI(LocalDateTime created) {
        super(created);
    }

    public static void main(String[] args) {

        Item time = new Item();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String currentDateTimeFormat = formatter.format(time.getCreated());
        System.out.println(currentDateTimeFormat);
    }
}
