package com.jishnu.notification_queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueManager {
    private Queue<Notification> queue = new LinkedList<>();

    public void addNotification(Notification notification) {
        queue.add(notification);
        System.out.println("Added: " + notification.getId());
    }

    public Notification processNext() {
        Notification notification = queue.poll();
        if (notification != null) {
            notification.setStatus("SENT");
            System.out.println("Processed: " + notification.getId());
        }
        return notification;
    }

    public Notification peekNext() {
        return queue.peek();
    }

    public int getQueueSize() {
        return queue.size();
    }

    public void displayAllNotifications() {
        for (Notification n : queue) {
            System.out.println("ID: " + n.getId() +
                               " | Recipient: " + n.getRecipient() +
                               " | Message: " + n.getMessageContent() +
                               " | Status: " + n.getStatus());
        }
    }
    public Notification searchNotificationById(String id) {
    for (Notification notification : queue) {
        if (notification.getId().equals(id)) {
            System.out.println("Found Notification");
            System.out.println("ID: " + notification.getId());
            System.out.println("Recipient: " + notification.getRecipient());
            System.out.println("Status: " + notification.getStatus());
            return notification;
        }
    }
    System.out.println("Notification not found for ID: " + id);
    return null;
}
public void processAllNotifications() {
    while (!queue.isEmpty()) {
        processNext();
    }
}
}