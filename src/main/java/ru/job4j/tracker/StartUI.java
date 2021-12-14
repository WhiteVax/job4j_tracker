package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class StartUI  {

    public static void main(String[] args) {

        Item time = new Item();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String currentDateTimeFormat = formatter.format(time.getCreated());
        System.out.println(currentDateTimeFormat);

        Item item = new Item();
        System.out.println(item.toString());
    }
}
