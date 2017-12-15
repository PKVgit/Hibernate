import hibernate_methods.*;
import liquibase.exception.LiquibaseException;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import run.Connect;
import run.Main;
import java.sql.SQLException;

public class HibernateTest {

    @BeforeClass
    public static void onlyOnce() throws SQLException, ClassNotFoundException, LiquibaseException {
        Connect.connect();
    }

    @AfterClass
    public static void afterTest() throws SQLException, ClassNotFoundException {
        Connect.connection.close();
    }

    @Test
    public void createTablesTest() throws SQLException, LiquibaseException, ClassNotFoundException {
        Main.createTables(Main.sessionFactory);
        AlbumsRunner albumsRunner = new AlbumsRunner(new Configuration().configure().buildSessionFactory());
        System.out.println(albumsRunner.listAlbums().get(0).toString());
    }

    @Test
    public void getObjectsTest() throws SQLException, LiquibaseException, ClassNotFoundException {
        Main.createTables(new Configuration().configure().buildSessionFactory());

        AlbumsRunner albumsRunner = new AlbumsRunner(new Configuration().configure().buildSessionFactory());
        System.out.println(albumsRunner.listAlbums().get(0).toString());

        BandsRunner bandsRunner = new BandsRunner(new Configuration().configure().buildSessionFactory());
        System.out.println(bandsRunner.listBands().get(0).toString());

        ClipsRunner clipsRunner = new ClipsRunner(new Configuration().configure().buildSessionFactory());
        System.out.println(clipsRunner.listClips().get(0).toString());

        SitesRunner sitesRunner = new SitesRunner(new Configuration().configure().buildSessionFactory());
        System.out.println(sitesRunner.listSites().get(0).toString());

        SongsRunner songsRunner = new SongsRunner(new Configuration().configure().buildSessionFactory());
        System.out.println(songsRunner.listSongs().get(0).toString());

    }

    @Test
    public void updateTest() throws SQLException, LiquibaseException, ClassNotFoundException {
        Main.createTables(new Configuration().configure().buildSessionFactory());

        AlbumsRunner albumsRunner = new AlbumsRunner(new Configuration().configure().buildSessionFactory());
        albumsRunner.updateAlbum(1, "New Albums");

        ClipsRunner clipsRunner = new ClipsRunner(new Configuration().configure().buildSessionFactory());
        clipsRunner.updateClip(1, "4:29");

        BandsRunner bandsRunner = new BandsRunner(new Configuration().configure().buildSessionFactory());
        bandsRunner.updateBand(1, "New Bands");

        SitesRunner sitesRunner = new SitesRunner(new Configuration().configure().buildSessionFactory());
        sitesRunner.updateSite(1, "NewSites.com");

        SongsRunner songsRunner = new SongsRunner(new Configuration().configure().buildSessionFactory());
        songsRunner.updateSong(1, "New Song");
    }

    @Test
    public void addRowTest() throws SQLException, LiquibaseException, ClassNotFoundException {
        Main.createTables(new Configuration().configure().buildSessionFactory());

        AlbumsRunner albumsRunner = new AlbumsRunner(new Configuration().configure().buildSessionFactory());
        albumsRunner.addAlbum(4, "Ok", 2333, 5, 3 );
        albumsRunner.removeAlbum(4);

        ClipsRunner clipsRunner = new ClipsRunner(new Configuration().configure().buildSessionFactory());
        clipsRunner.addClip(4, "2:01", 12);
        clipsRunner.removeClip(4);

        SitesRunner sitesRunner = new SitesRunner(new Configuration().configure().buildSessionFactory());
        sitesRunner.addSite(4, "newLink.com", 3, 3,3,3);
        sitesRunner.removeSite(4);

        SongsRunner songsRunner = new SongsRunner(new Configuration().configure().buildSessionFactory());
        songsRunner.addSong(4, "Ok", "2:45", 2);
        songsRunner.removeSong(4);

        BandsRunner bandsRunner = new BandsRunner(new Configuration().configure().buildSessionFactory());
        bandsRunner.addBand(4, "Ok", 1999,10,"USA", 2);
        bandsRunner.removeBand(4);
    }
}
