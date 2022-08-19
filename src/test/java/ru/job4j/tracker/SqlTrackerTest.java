package ru.job4j.tracker;

import org.junit.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import static org.assertj.core.api.Assertions.*;

public class SqlTrackerTest {

    private static Connection connection;

    @Ignore
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

    @Ignore
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @Ignore
    public void wipeTable() throws SQLException {
        try (var statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Ignore
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        var tracker = new SqlTracker(connection);
        var item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId())).isEqualTo(item);
    }

    @Ignore
    public void whenSaveItemsAndShowAll() {
        var tracker = new SqlTracker(connection);
        Item[] items = {new Item("laptop"),
                       new Item("desktop")};
        tracker.add(items[0]);
        tracker.add(items[1]);
        assertThat(tracker.findAll().get(0)).isEqualTo(items[0]);
    }

    @Ignore
    public void whenSaveItemsAndDelete() {
        var tracker = new SqlTracker(connection);
        Item[] items = {new Item("laptop"),
                new Item("desktop")};
        var first = tracker.add(items[0]).getId();
        var second = tracker.add(items[1]).getId();
        tracker.delete(first);
        assertThat(tracker.delete(second)).isTrue();
    }

    @Ignore
    public void whenSaveItemsAndEdit() {
        var tracker = new SqlTracker(connection);
        Item[] items = {new Item("laptop"),
                new Item("desktop")};
        tracker.add(items[0]);
        var second = tracker.add(items[1]).getId();
        var newItem = new Item("laptop asus");
        tracker.replace(second, newItem);
        assertThat(tracker.findById(second).getName()).isEqualTo(newItem.getName());
    }

    @Ignore
    public void whenSaveItemsAndFindByName() {
        var tracker = new SqlTracker(connection);
        Item[] items = {new Item("laptop"),
                new Item("desktop"),
                new Item("desktop")};
        tracker.add(items[0]);
        tracker.add(items[1]);
        tracker.add(items[2]);
        assertThat(tracker.findByName("desktop").get(1).getName()).isEqualTo(items[2].getName());
    }
}



