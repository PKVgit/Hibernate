package run;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
    public static final String db_url ="jdbc:postgresql://127.0.0.1:5432/Earth";
    public static final String user = "postgres";
    public static final String password = "123";

    public static Connection connection = null;

    public static Connection connect() {
        System.out.println("Try connect to DB");

        try {
            Class.forName("org.postgresql.Driver");
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
        System.out.println("Successfully connection");


        try {
            connection = DriverManager.getConnection(db_url, user , password);
        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
            return null;
        }
        if(connection!= null) {
            System.out.println("Connected");
        }
        else {
            System.out.println("Some problem");
        }
        return connection;
    }
}
