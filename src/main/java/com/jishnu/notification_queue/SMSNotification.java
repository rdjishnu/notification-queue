package com.jishnu.notification_queue;

public class SMSNotification extends Notification {
    private String phoneNumber;

    public SMSNotification(String id, String recipient, String messageContent, String phoneNumber) {
        super(id, recipient, messageContent);
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}