package hibernate_methods;

import items.Cities;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;


    public class CitiesRunner {
    private static SessionFactory sessionFactory;

    public CitiesRunner(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addCities(int id, String Name, int years) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        Cities cities = new Cities(id, Name, years);
        session.save(cities);
        transaction.commit();
        session.close();
    }

    public void updateCities(int id, String Name) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        Cities cities = (Cities) session.get(Cities.class, id);
        cities.setName(Name);
        session.update(cities);
        transaction.commit();
        session.close();
    }

    public void removeCities(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        Cities cities = (Cities) session.get(Cities.class, id);
        session.delete(cities);
        transaction.commit();
        session.close();
    }

    public List listCities() {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        List city = session.createQuery("FROM Cities").list();

        transaction.commit();
        session.close();
        return city;
    }
}
