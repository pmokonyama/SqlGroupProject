import org.junit.jupiter.api.Test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import static org.junit.jupiter.api.Assertions.*;

public class DatabaseReportsTest {

    // Replace with your actual database credentials
    private static final String URL = "jdbc:mysql://localhost:3306/banking_db";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    @Test
    public void testCustomerBalance() {
        int customerId = 1;  // Example customer ID
        double expectedBalance = 1000.0;  // Replace with the expected balance

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            // Create the SQL query to retrieve balance for the given customer ID
            String query = "SELECT SUM(balance) AS total_balance FROM accounts WHERE customer_id = " + customerId;

            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(query)) {

                if (rs.next()) {
                    double actualBalance = rs.getDouble("total_balance");
                    // Assert that the retrieved balance matches the expected balance
                    assertEquals(expectedBalance, actualBalance, 0.01, "Balance doesn't match expected value.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            fail("Database connection or query failed.");
        }
    }
}
