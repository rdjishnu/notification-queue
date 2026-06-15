package com.jishnu.notification_queue;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Notification implements Comparable<Notification> {

    @Id
    private String id;

    @NotBlank(message = "Recipient cannot be empty")
    private String recipient;

    @NotBlank(message = "Message content cannot be empty")
    private String messageContent;

    private NotificationStatus status;

    @NotNull(message = "Priority cannot be null")
    private NotificationPriority priority;

    private int retryCount;

    public Notification() {
    }

    public Notification(String id, String recipient, String messageContent) {
        this.id = id;
        this.recipient = recipient;
        this.messageContent = messageContent;
        this.status = NotificationStatus.PENDING;
        this.priority = NotificationPriority.LOW;
        this.retryCount = 0;
    }

    public Notification(String id, String recipient, String messageContent, NotificationPriority priority) {
        this.id = id;
        this.recipient = recipient;
        this.messageContent = messageContent;
        this.status = NotificationStatus.PENDING;
        this.priority = priority;
        this.retryCount = 0;
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

    public int getRetryCount() {
        return retryCount;
    }

    public void setRetryCount(int retryCount) {
        this.retryCount = retryCount;
    }

    @Override
    public int compareTo(Notification other) {
        return this.priority.compareTo(other.priority);
    }
}