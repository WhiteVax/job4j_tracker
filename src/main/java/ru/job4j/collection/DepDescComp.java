package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] l = left.split("/");
        String[] r = right.split("/");
        int rsl = r[0].compareTo(l[0]);
        return rsl == 0 ? left.compareTo(right) : rsl;
    }
}


