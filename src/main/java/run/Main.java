package run;

import hibernate_methods.*;
import liquibase.Contexts;
import liquibase.LabelExpression;
import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.FileSystemResourceAccessor;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;
import java.sql.SQLException;

public class Main {

    public static SessionFactory sessionFactory;

    public static void main(String[] args) throws ClassNotFoundException, SQLException, LiquibaseException {
        Connect.connect();
        sessionFactory = new Configuration().configure().buildSessionFactory();
        createTables(sessionFactory);
    }

    public static void createTables(SessionFactory sessionFactory) throws ClassNotFoundException, SQLException, LiquibaseException {
        Database database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(Connect.connection));

        File create_tables = new File(ClassLoader.getSystemResource("liquibase/1.0-create-tables.xml").getFile());
        Liquibase create = new liquibase.Liquibase(create_tables.toString(), new FileSystemResourceAccessor(), database);
        create.clearCheckSums();
        create.update(new Contexts(), new LabelExpression());

        File set_data = new File(ClassLoader.getSystemResource("liquibase/2.0-set-data.xml").getFile());
        Liquibase insert = new liquibase.Liquibase(set_data.toString(), new FileSystemResourceAccessor(), database);
        insert.update(new Contexts(), new LabelExpression());

        File delete_all_rows = new File(ClassLoader.getSystemResource("liquibase/3.0-delete-all-rows.xml").getFile());
        Liquibase delete = new liquibase.Liquibase(delete_all_rows.toString(), new FileSystemResourceAccessor(), database);
        delete.update(new Contexts(), new LabelExpression());

        ContinentsRunner continentsRunner = new ContinentsRunner(sessionFactory);
        CountriesRunner countriesRunner = new CountriesRunner(sessionFactory);
        CitiesRunner citiesRunner = new CitiesRunner(sessionFactory);
        GroupsRunner groupsRunner = new GroupsRunner(sessionFactory);
        HumansRunner humansRunner = new HumansRunner(sessionFactory);
    }
}
