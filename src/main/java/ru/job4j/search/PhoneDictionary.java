package ru.job4j.search;

import java.util.ArrayList;
import java.util.Objects;

public class PhoneDictionary {
    private final ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        for (Person person: persons) {
            if (Objects.equals(person.getName(), key)) {
                result.add(person);
            }
        }
        return result;
    }
}
