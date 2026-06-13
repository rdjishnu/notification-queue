package com.jishnu.notification_queue;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Notification implements Comparable<Notification> {

    @Id
    private String id;
    private String recipient;
    private String messageContent;
    private NotificationStatus status;
    private NotificationPriority priority;

    public Notification() {
    }

    public Notification(String id, String recipient, String messageContent) {
        this.id = id;
        this.recipient = recipient;
        this.messageContent = messageContent;
        this.status = NotificationStatus.PENDING;
        this.priority = NotificationPriority.LOW;
    }

    public Notification(String id, String recipient, String messageContent, NotificationPriority priority) {
        this.id = id;
        this.recipient = recipient;
        this.messageContent = messageContent;
        this.status = NotificationStatus.PENDING;
        this.priority = priority;
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

    public NotificationPriority getPriority() {
        return priority;
    }

    @Override
    public int compareTo(Notification other) {
        return this.priority.compareTo(other.priority);
    }
}