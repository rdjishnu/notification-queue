package com.jishnu.notification_queue;

public class EmailNotification extends Notification {
    private String subject;

    public EmailNotification(String id, String recipient, String messageContent, String subject) {
        super(id, recipient, messageContent);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }
}