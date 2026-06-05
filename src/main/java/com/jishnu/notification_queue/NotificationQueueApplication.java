package com.jishnu.notification_queue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NotificationQueueApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotificationQueueApplication.class, args);

        QueueManager manager = new QueueManager();

        manager.addNotification(new Notification("1", "rdjp@gmail.com", "Welcome!"));
        manager.addNotification(new Notification("2", "ronny@gmail.com", "Your order is ready"));
        manager.addNotification(new Notification("3", "lh44@gmail.com", "Reset your password"));

        System.out.println("Queue size: " + manager.getQueueSize());
        System.out.println("Next up: " + manager.peekNext().getRecipient());

        manager.processNext();
        manager.processNext();

        System.out.println("Queue size after processing: " + manager.getQueueSize());
    }
}