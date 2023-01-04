package ru.job4j.tracker;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class HbmTrackerTest {

    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure()
            .build();
    private final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata()
            .buildSessionFactory();

    @BeforeEach
    public void before() {
        var session = sf.openSession();
        session.beginTransaction();
        session.createQuery("DELETE FROM Item")
                .executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() throws Exception {
        try (var tracker = new HbmTracker()) {
            var item = new Item("test1");
            tracker.add(item);
            var result = tracker.findById(item.getId());
            assertThat(result.getName()).isEqualTo(item.getName());
        }
    }

    @Test
    public void whenAddItemsThenGetAll() throws Exception {
        try (var tracker = new HbmTracker()) {
            var first = new Item("first");
            var second = new Item("second");
            tracker.add(first);
            tracker.add(second);
            assertThat(tracker.findAll())
                    .contains(first, second)
                    .hasSize(2);
        }
    }

    @Test
    public void whenAddItemThenUpdate() throws Exception {
        try (var tracker = new HbmTracker()) {
            var first = new Item("first");
            tracker.add(first);
            first.setName("second");
            tracker.replace(first.getId(), first);
            assertThat(tracker.findById(first.getId()).getName())
                    .isEqualTo(first.getName());
        }
    }

    @Test
    public void whenAddItemsThenFindByName() throws Exception {
        try (var tracker = new HbmTracker()) {
            var first = new Item("first");
            var second = new Item("first");
            tracker.add(first);
            tracker.add(second);
            assertThat(tracker.findAll())
                    .contains(first, second)
                    .hasSize(2);
        }
    }

    @Test
    public void whenAddItemThenDelete() throws Exception {
        try (var tracker = new HbmTracker()) {
            var item = new Item("test");
            tracker.add(item);
            tracker.delete(item.getId());
            assertThat(tracker.findById(item.getId()).getName()).isNull();
        }
    }
}