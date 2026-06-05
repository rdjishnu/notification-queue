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
}