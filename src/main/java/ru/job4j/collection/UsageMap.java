package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {
    public static void main(String[] args) {

        Map<String, String> storage = new HashMap<>();
        storage.put("test@gmail.com", "name surname");
        storage.put("test@gmail.com", "name surname");
        storage.put("second@gmail.com", "name surname");
        storage.put("second@gmail.com", "name surname");

        for (Map.Entry<String, String> entry : storage.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + " : " + value);
        }
    }
}
