package ru.job4j.collection;

import org.junit.Test;
import java.util.Comparator;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.MatcherAssert.assertThat;

public class JobTest {

    @Test
    public void whenComparatorByPriority() {
        int rsl = new Job("Fix", 15)
                .compareTo(
                        new Job("Remote", 13)
                );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorDescByPriority() {
        Comparator<Job> cmpDescPriority = new JobDescByPriority();
        int rsl = cmpDescPriority.compare(
                new Job("Fix", 15),
                new Job("Remote", 13)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorByName() {
        Comparator<Job> cmpName = new JobSortByName();
        int rsl = cmpName.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 0)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorDescByName() {
        Comparator<Job> cmpDescByName = new JobDescByName();
        int rsl = cmpDescByName.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 0)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorDescNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 5)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorPriorityAndName() {
        Comparator<Job> cmpPriorityName = new JobSortByPriority().thenComparing(new JobSortByName());
        int rsl = cmpPriorityName.compare(
                new Job("Impl task", 5),
                new Job("Fix bug", 10)
        );
        assertThat(rsl, lessThan(0));
    }
}
