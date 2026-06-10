package com.jishnu.notification_queue;

public class PaymentNotification extends Notification {
    private double amount;

    public PaymentNotification(String id, String recipient, String messageContent, double amount) {
        super(id, recipient, messageContent);
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}