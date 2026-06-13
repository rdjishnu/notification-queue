package com.jishnu.notification_queue;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QueueManager {

    private Queue<Notification> queue = new PriorityQueue<>();
    @Autowired
    private NotificationRepository notificationRepository;

    public void addNotification(Notification notification) {
        queue.add(notification);
        notificationRepository.save(notification);
        System.out.println("Added: " + notification.getId());
    }

    public Notification processNext() {
        Notification notification = queue.poll();
        if (notification != null) {
            notification.setStatus(NotificationStatus.SENT);
            notificationRepository.save(notification);
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
        List<Notification> all = notificationRepository.findAll();
        for (Notification n : all) {
            System.out.println("ID: " + n.getId() +
                               " | Recipient: " + n.getRecipient() +
                               " | Message: " + n.getMessageContent() +
                               " | Status: " + n.getStatus());
        }
    }

    public Notification searchNotificationById(String id) {
        return notificationRepository.findById(id).orElse(null);
    }

    public void processAllNotifications() {
        while (!queue.isEmpty()) {
            processNext();
        }
    }

    public long countPendingNotifications() {
        return notificationRepository.findAll().stream()
                .filter(n -> n.getStatus() == NotificationStatus.PENDING)
                .count();
    }

    public long countSentNotifications() {
        return notificationRepository.findAll().stream()
                .filter(n -> n.getStatus() == NotificationStatus.SENT)
                .count();
    }
}