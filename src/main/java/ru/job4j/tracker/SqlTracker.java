package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store, AutoCloseable {

    private Connection connection;

    public SqlTracker(Connection connection) {
        this.connection = connection;
    }

    public SqlTracker() {
    }

    public void init() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("app.properties")) {
            var config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    public Item getItem(ResultSet set) throws SQLException {
        return new Item(set.getInt(1), set.getString(2), set.getTimestamp(3));
    }

    @Override
    public Item add(Item item) {
        try (var statement = connection.prepareStatement(
                "INSERT INTO items(name, created) VALUES (?, ?);",
                Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, item.getName());
            statement.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            statement.execute();
            try (var id = statement.getGeneratedKeys()) {
                if (id.next()) {
                    item.setId(id.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        var rsl = false;
        try (var statement = connection.prepareStatement(
                "UPDATE items SET name = ?, created = ? WHERE id = ?")) {
            statement.setString(1, item.getName());
            statement.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            statement.setInt(3, id);
            rsl = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rsl;
    }

    @Override
    public boolean delete(int id) {
        var rsl = false;
        try (var statement = connection.prepareStatement(
                "DELETE FROM items WHERE id = ?")) {
            statement.setInt(1, id);
            rsl = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rsl;
    }

    @Override
    public List<Item> findAll() {
        List<Item> rsl = new ArrayList<>();
        try (var statement = connection.createStatement()) {
            var set = statement.executeQuery("SELECT * FROM items");
            while (set.next()) {
                rsl.add(getItem(set));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rsl;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> rsl = new ArrayList<>();
        try (var statement = connection.prepareStatement("SELECT * FROM items WHERE name = ?")) {
            statement.setString(1, key);
            var set = statement.executeQuery();
            while (set.next()) {
                rsl.add(getItem(set));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rsl;
    }

    @Override
    public Item findById(int id) {
        Item item = null;
        try (var statement = connection.prepareStatement("SELECT * FROM items WHERE id = ?")) {
            statement.setInt(1, id);
            var set = statement.executeQuery();
            if (set.next()) {
                item = (getItem(set));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }
}
