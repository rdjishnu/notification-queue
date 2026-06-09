package com.jishnu.notification_queue;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    private final QueueManager queueManager = new QueueManager();

    @PostMapping("/add")
    public String addNotification(@RequestBody Notification notification) {
        queueManager.addNotification(notification);
        return "Notification added: " + notification.getId();
    }

    @GetMapping("/all")
    public String getAllNotifications() {
        queueManager.displayAllNotifications();
        return "Check terminal for output";
    }

    @DeleteMapping("/process")
    public String processNext() {
        Notification n = queueManager.processNext();
        if (n != null) {
            return "Processed: " + n.getId() + " | Status: " + n.getStatus();
        }
        return "Queue is empty";
    }

    @GetMapping("/size")
    public String getSize() {
        return "Queue size: " + queueManager.getQueueSize();
    }

    @GetMapping("/search/{id}")
    public String searchById(@PathVariable String id) {
        Notification n = queueManager.searchNotificationById(id);
        if (n != null) {
            return "Found - ID: " + n.getId() + " | Recipient: " + n.getRecipient() + " | Status: " + n.getStatus();
        }
        return "Not found";
    }
    @GetMapping("/count/pending")
public String countPending() {
    return "Pending: " + queueManager.countPendingNotifications();
}

@GetMapping("/count/sent")
public String countSent() {
    return "Sent: " + queueManager.countSentNotifications();
}
}