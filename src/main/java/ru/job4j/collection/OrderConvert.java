package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class OrderConvert {
    public static HashMap<String, Order> process(List<Order> orders) {
       Map<String, Order> map = new HashMap<>();
        for (Order order : orders) {
            map.put(order.getNumber(), order);
        }
        return new HashMap<>(map);
    }
}
