CREATE DATABASE IF NOT EXISTS payment_gateway;
USE payment_gateway;

CREATE TABLE IF NOT EXISTS transactions (
    id INT AUTO_INCREMENT PRIMARY KEY,
    transaction_id VARCHAR(50) UNIQUE NOT NULL,
    sender VARCHAR(100) NOT NULL,
    receiver VARCHAR(100) NOT NULL,
    amount DECIMAL(12,2) NOT NULL,
    currency VARCHAR(10) NOT NULL,
    status VARCHAR(20) NOT NULL,
    transaction_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS refunds (
    id INT AUTO_INCREMENT PRIMARY KEY,
    transaction_id VARCHAR(50) NOT NULL,
    refund_amount DECIMAL(12,2) NOT NULL,
    refund_status VARCHAR(20) NOT NULL,
    refund_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

SELECT * FROM transactions;
