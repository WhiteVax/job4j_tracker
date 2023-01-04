package ru.job4j.tracker;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class HbmTracker implements Store, AutoCloseable {
    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();
    private final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();

    @Override
    public Item add(Item item) {
        var session = sf.openSession();
        session.beginTransaction();
        session.save(item);
        session.getTransaction().commit();
        session.close();
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        var session = sf.openSession();
        int rsl = 0;
        try {
            session.beginTransaction();
            rsl = session.createQuery("UPDATE Item i SET i.name = :fName, i.created = :fCreated WHERE i.id = :fId", Item.class)
                    .setParameter("fName", item.getName())
                    .setParameter("fCreated", item.getCreated())
                    .setParameter("fId", id)
                    .executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.beginTransaction().rollback();
        }
        return rsl != 0;
    }

    @Override
    public boolean delete(int id) {
        var session = sf.openSession();
        var rsl = 0;
        try {
            session.beginTransaction();
            rsl = session.createQuery("DELETE Item i WHERE i.id = :fId", Item.class)
                    .setParameter("fId", id)
                    .executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
        return rsl != 0;
    }

    @Override
    public List<Item> findAll() {
        var session = sf.openSession();
        session.beginTransaction();
        List<Item> items =
                session.createQuery("FROM Item i ORDER BY i.id", Item.class).list();
        session.getTransaction().commit();
        session.close();
        return items;
    }

    @Override
    public List<Item> findByName(String key) {
        var session = sf.openSession();
        session.beginTransaction();
        List<Item> items = session.createQuery(
                "FROM Item i WHERE i.name = :fName ORDER BY i.id", Item.class)
                .setParameter("fName", key).list();
        session.getTransaction().commit();
        session.close();
        return items;
    }

    @Override
    public Item findById(int id) {
        var session = sf.openSession();
        session.beginTransaction();
        var item = session.createQuery("FROM Item i WHERE i.id = :fId", Item.class)
                .setParameter("fId", id)
                .uniqueResultOptional()
                .orElse(new Item());
        session.getTransaction().commit();
        session.close();
        return item;
    }

    @Override
    public void close() throws Exception {
        StandardServiceRegistryBuilder.destroy(registry);
    }
}
