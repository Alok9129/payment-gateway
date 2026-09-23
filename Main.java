import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        PaymentService paymentService = new PaymentService();
        PaymentDAO paymentDAO = new PaymentDAO();

        System.out.println("=================================");
        System.out.println("      ONLINE PAYMENT GATEWAY");
        System.out.println("=================================");

        System.out.print("Enter Sender Name: ");
        String sender = scanner.nextLine();

        System.out.print("Enter Receiver Name: ");
        String receiver = scanner.nextLine();

        System.out.print("Enter Amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Enter Currency (INR/USD/EUR): ");
        String currency = scanner.nextLine();

        System.out.print("Enter 16-digit Card Number: ");
        String cardNumber = scanner.nextLine();

        System.out.print("Enter 4-digit PIN: ");
        String pin = scanner.nextLine();

        String result = paymentService.processPayment(
                sender, receiver, amount, cardNumber, pin);

        if (result.startsWith("TXN-")) {
            paymentDAO.saveTransaction(
                    result, sender, receiver, amount, currency, "SUCCESS");
        } else {
            System.out.println(result);
        }

        scanner.close();
    }
}
