package com.jishnu.notification_queue;

public class Notification {
    private String id;
    private String recipient;
    private String messageContent;
    private NotificationStatus status;

    public Notification(String id, String recipient, String messageContent) {
        this.id = id;
        this.recipient = recipient;
        this.messageContent = messageContent;
        this.status = NotificationStatus.PENDING;
    }

    public String getId() {
        return id;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public NotificationStatus getStatus() {
        return status;
    }

    public void setStatus(NotificationStatus status) {
        this.status = status;
    }
}