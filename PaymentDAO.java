import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PaymentDAO {

    private static final String URL =
            "jdbc:mysql://localhost:3306/payment_gateway";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public void saveTransaction(String transactionId, String sender,
                                String receiver, double amount,
                                String currency, String status) {

        String sql = """
            INSERT INTO transactions
            (transaction_id, sender, receiver, amount, currency, status)
            VALUES (?, ?, ?, ?, ?, ?)
            """;

        try (Connection connection =
                     DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setString(1, transactionId);
            statement.setString(2, sender);
            statement.setString(3, receiver);
            statement.setDouble(4, amount);
            statement.setString(5, currency);
            statement.setString(6, status);

            statement.executeUpdate();
            System.out.println("Transaction saved to database.");

        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }
    }
}
