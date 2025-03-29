import java.sql.*;

public class DatabaseConnection {

    static String url = "jdbc:mysql://localhost:3306/banking_db";
    static String user = "root";
    static String  password = "root";
    static Connection connection;

    public static Connection DBConnection() {
        try{
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the database!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}

