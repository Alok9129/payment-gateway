import java.util.UUID;

public class PaymentService {

    public String processPayment(String sender, String receiver,
                                 double amount, String cardNumber,
                                 String pin) {

        if (amount <= 0) return "Payment failed: Invalid amount";

        if (cardNumber == null || !cardNumber.matches("\\d{16}")) {
            return "Payment failed: Invalid card number";
        }

        if (pin == null || !pin.matches("\\d{4}")) {
            return "Payment failed: Invalid PIN";
        }

        // Demo fraud-risk rule
        if (amount > 100000) {
            return "Payment blocked: High-risk transaction";
        }

        String transactionId = "TXN-" +
                UUID.randomUUID().toString()
                .substring(0, 8).toUpperCase();

        System.out.println("\nPayment Successful");
        System.out.println("Transaction ID: " + transactionId);
        System.out.println("Sender: " + sender);
        System.out.println("Receiver: " + receiver);
        System.out.println("Amount: " + amount);
        System.out.println("Status: SUCCESS");

        return transactionId;
    }

    public String refundPayment(String transactionId, double amount) {
        if (transactionId == null || transactionId.isBlank()) {
            return "Refund failed: Invalid transaction ID";
        }
        if (amount <= 0) {
            return "Refund failed: Invalid amount";
        }
        return "Refund successful | Transaction: " + transactionId +
               " | Amount: " + amount;
    }
}
