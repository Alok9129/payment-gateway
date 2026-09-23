document.getElementById("paymentForm")
    .addEventListener("submit", function(event) {

    event.preventDefault();

    const amount = Number(document.getElementById("amount").value);
    const cardNumber = document.getElementById("cardNumber").value;
    const pin = document.getElementById("pin").value;

    if (amount <= 0) {
        showResult("Enter a valid amount.");
        return;
    }

    if (!/^\d{16}$/.test(cardNumber)) {
        showResult("Card number must contain exactly 16 digits.");
        return;
    }

    if (!/^\d{4}$/.test(pin)) {
        showResult("PIN must contain exactly 4 digits.");
        return;
    }

    if (amount > 100000) {
        showResult("Transaction blocked for security reasons.");
        return;
    }

    const transactionId =
        "TXN-" + Math.random().toString(36)
        .substring(2, 10).toUpperCase();

    showResult("Payment Successful! Transaction ID: " + transactionId);
});

function showResult(message) {
    document.getElementById("result").innerText = message;
}
