package hibernate_methods;

import items.Continents;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class ContinentsRunner {

    private static SessionFactory sessionFactory;

    public ContinentsRunner(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addAlbum(int id, String name, int dateRel, int numbOfSongs, int songId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        Continents albums = new Continents(id, name, dateRel, numbOfSongs, songId);
        session.save(albums);
        transaction.commit();
        session.close();
    }

    public void updateAlbum(int id, String name) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        Continents albums = (Continents) session.get(Continents.class, id);
        albums.setName(name);
        session.update(albums);
        transaction.commit();
        session.close();
    }

    public void removeAlbum(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        Continents albums = (Continents) session.get(Continents.class, id);
        session.delete(albums);
        transaction.commit();
        session.close();
    }

    public List listAlbums() {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        List albums = session.createQuery("FROM Continents").list();

        transaction.commit();
        session.close();
        return albums;
    }
}
