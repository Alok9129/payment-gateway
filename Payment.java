public class Payment {
    private String transactionId;
    private String sender;
    private String receiver;
    private double amount;
    private String currency;
    private String status;

    public Payment(String transactionId, String sender, String receiver,
                   double amount, String currency, String status) {
        this.transactionId = transactionId;
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
        this.currency = currency;
        this.status = status;
    }

    public String getTransactionId() { return transactionId; }
    public String getSender() { return sender; }
    public String getReceiver() { return receiver; }
    public double getAmount() { return amount; }
    public String getCurrency() { return currency; }
    public String getStatus() { return status; }

    public void setStatus(String status) {
        this.status = status;
    }
}
