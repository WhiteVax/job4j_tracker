package ru.job4j.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionRange {
    public List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> rsl = new ArrayList<>();
        double tmp;
        for (int i = start; i < end; i++) {
            tmp = func.apply((double) i);
            rsl.add(tmp);
        }
        return rsl;
    }
}
