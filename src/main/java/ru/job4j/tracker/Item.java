package ru.job4j.tracker;

import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@ToString
@Getter @Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Item {
    @EqualsAndHashCode.Include
    private int id;
    @EqualsAndHashCode.Include
    private String name;

    private LocalDateTime created = LocalDateTime.now();

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    public Item() {
    }

    public Item(LocalDateTime created) {
        this.created = created;
    }

    public Item(int id) {
        this.id = id;
    }

    public Item(String name) {
        this.name = name;
    }

    public Item(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public Item(int anInt, String string, Timestamp date) {
        this.id = anInt;
        this.name = string;
        this.created = date.toLocalDateTime();
    }
}