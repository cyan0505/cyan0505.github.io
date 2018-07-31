import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {

    private Connection c;
    private Statement stmt;

    private static DatabaseConnection instance = new DatabaseConnection();

    private DatabaseConnection() {

    }

    public static DatabaseConnection getInstance() {
        return instance;
    }

    public void getConnetion() {
        try {
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/QuestStore", "postgres", "yakuza06"); // set user and password
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public void closeConnection() {
        try {
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
