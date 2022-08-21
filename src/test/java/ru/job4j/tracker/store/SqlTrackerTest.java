package ru.job4j.tracker.store;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.SqlTracker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import static org.assertj.core.api.Assertions.*;

public class SqlTrackerTest {

    private static Connection connection;

    @BeforeClass
    public static void initConnection() {
        try (var in = SqlTrackerTest.class.getClassLoader().getResourceAsStream("test.properties")) {
            var config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterClass
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @After
    public void wipeTable() throws SQLException {
        try (var statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        var tracker = new SqlTracker(connection);
        var item = tracker.add(new Item("item"));
        assertThat(tracker.findById(item.getId())).isEqualTo(item);
    }

    @Test
    public void whenSaveItemsAndShowAll() {
        var tracker = new SqlTracker(connection);
        var first = tracker.add(new Item("laptop"));
        var second = tracker.add(new Item("desktop"));
        assertThat(tracker.findAll()).containsAll(List.of(first, second));
    }

    @Test
    public void whenSaveItemsAndDelete() {
        var tracker = new SqlTracker(connection);
        var first = tracker.add(new Item("laptop"));
        tracker.delete(first.getId());
        assertThat(tracker.findById(first.getId())).isNull();
    }

    @Test
    public void whenSaveItemsAndEdit() {
        var tracker = new SqlTracker(connection);
        var first = tracker.add(new Item("laptop"));
        tracker.replace(first.getId(), new Item("desktop"));
        assertThat(tracker.findById(first.getId()).getName()).isEqualTo("desktop");
    }

    @Test
    public void whenSaveItemsAndFindByName() {
        var tracker = new SqlTracker(connection);
        var first = tracker.add(new Item("laptop"));
        tracker.add(new Item("desktop"));
        assertThat(tracker.findByName("laptop").get(0)).isEqualTo(first);
    }
}
