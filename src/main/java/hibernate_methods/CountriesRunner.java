package hibernate_methods;

import items.Countries;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class CountriesRunner {

    private static SessionFactory sessionFactory;

    public CountriesRunner(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addBand(int id, String name, int dateRel, int numbOfAlb, String country, int albumId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        Countries bands = new Countries(id, name, dateRel, numbOfAlb, country, albumId);
        session.save(bands);
        transaction.commit();
        session.close();
    }

    public void updateBand(int id, String name) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        Countries bands = (Countries) session.get(Countries.class, id);
        bands.setName(name);
        session.update(bands);
        transaction.commit();
        session.close();
    }

    public void removeBand(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        Countries bands = (Countries) session.get(Countries.class, id);
        session.delete(bands);
        transaction.commit();
        session.close();
    }

    public List listBands() {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        List bands = session.createQuery("FROM Countries").list();

        transaction.commit();
        session.close();
        return bands;
    }
}
