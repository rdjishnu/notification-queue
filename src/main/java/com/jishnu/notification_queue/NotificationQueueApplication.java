package com.jishnu.notification_queue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NotificationQueueApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotificationQueueApplication.class, args);

        QueueManager manager = new QueueManager();

        manager.addNotification(new EmailNotification("1", "alice@gmail.com", "Welcome!", "Account Created"));
        manager.addNotification(new SMSNotification("2", "bob@gmail.com", "Your OTP is 1234", "+91 9876543210"));
        manager.addNotification(new PaymentNotification("3", "charlie@gmail.com", "Payment received", 999.99));

        System.out.println("--- All Notifications ---");
        manager.displayAllNotifications();

        System.out.println("Pending: " + manager.countPendingNotifications());

        System.out.println("--- Processing All ---");
        manager.processAllNotifications();

        System.out.println("Pending: " + manager.countPendingNotifications());
        System.out.println("Queue size: " + manager.getQueueSize());
    }
}