package hibernate_methods;

import items.Groups;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class GroupsRunner {

    private static SessionFactory sessionFactory;

    public GroupsRunner(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addSite(int id, String link, int bandId, int albumId, int  songId, int clipId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        Groups sites = new Groups(id, link, bandId, albumId, songId, clipId);
        session.save(sites);
        transaction.commit();
        session.close();
    }

    public void updateSite(int id, String link) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        Groups sites = (Groups) session.get(Groups.class, id);
        sites.setName(link);
        session.update(sites);
        transaction.commit();
        session.close();
    }

    public void removeSite(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        Groups sites = (Groups) session.get(Groups.class, id);
        session.delete(sites);
        transaction.commit();
        session.close();
    }

    public List listSites() {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        List sites = session.createQuery("FROM Groups").list();

        transaction.commit();
        session.close();
        return sites;
    }
}
