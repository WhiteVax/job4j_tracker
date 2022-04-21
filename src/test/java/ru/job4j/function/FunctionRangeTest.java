package ru.job4j.function;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class FunctionRangeTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        FunctionRange func = new FunctionRange();
        List<Double> result = func.diapason(5, 8, x -> x * 2 + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunctionThenQuadraticResults() {
        FunctionRange func = new FunctionRange();
        List<Double> result = func.diapason(5, 8, x -> x * x);
        List<Double> expected = Arrays.asList(25D, 36D, 49D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenExponentialFunctionThenExponentialResults() {
        FunctionRange func = new FunctionRange();
        List<Double> result = func.diapason(5, 8, x -> Math.pow(4, x) + 1);
        List<Double> expected = Arrays.asList(1025D, 4097D, 16385D);
        assertThat(result, is(expected));
    }
}
