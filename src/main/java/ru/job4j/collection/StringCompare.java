package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int rsl = 0;
        int size = Math.max(right.length(), left.length());
        for (int i = 0; i <= size; i++) {
            char l = left.length() > i ? left.charAt(i) : Character.MIN_VALUE;
            char r = right.length() > i ? right.charAt(i) : Character.MIN_VALUE;
            if (Integer.compare(r, l) != 0) {
                rsl = Character.compare(l, r);
                break;
            }
        }
        return rsl;
    }
}
