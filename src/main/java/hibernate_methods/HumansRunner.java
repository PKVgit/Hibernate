package hibernate_methods;

import items.Humans;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HumansRunner {

    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();;

    public HumansRunner(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addSong(int id, String name, String songDuration, int clipId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        Humans songs = new Humans(id, name, songDuration, clipId);
        session.save(songs);
        transaction.commit();
        session.close();
    }

    public void updateSong(int id, String name) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        Humans songs = (Humans) session.get(Humans.class, id);
        songs.setName(name);
        session.update(songs);
        transaction.commit();
        session.close();
    }

    public void removeSong(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        Humans songs = (Humans) session.get(Humans.class, id);
        session.delete(songs);
        transaction.commit();
        session.close();
    }

    public List listSongs() {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        List songs = session.createQuery("FROM Humans").list();

        transaction.commit();
        session.close();
        return songs;
    }
}
