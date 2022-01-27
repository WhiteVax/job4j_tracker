package ru.job4j.collection;

import java.util.HashSet;
import java.util.Set;

public class UniqueText {
    public static boolean isEquals(String originText, String duplicateText) {
        boolean rsl = true;
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        Set<String> check = new HashSet<>();
        for (String cell : origin) {
            check.add(cell);
        }
        for (String duplicated : text) {
            if (!check.contains(duplicated)) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }
}
