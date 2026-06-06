package com.jishnu.notification_queue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NotificationQueueApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotificationQueueApplication.class, args);

        QueueManager manager = new QueueManager();

        manager.addNotification(new Notification("1", "alice@gmail.com", "Welcome!"));
        manager.addNotification(new Notification("2", "bob@gmail.com", "Your order is ready"));
        manager.addNotification(new Notification("3", "charlie@gmail.com", "Reset your password"));

        manager.displayAllNotifications();
        manager.searchNotificationById("2");

       manager.processAllNotifications();

        System.out.println("Queue size after processing: " + manager.getQueueSize());
    }
}