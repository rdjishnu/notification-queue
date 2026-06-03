package com.jishnu.notification_queue;

public class Notification {
    private String id;
    private String recipient;
    private String messageContent;
    private String status;

    public Notification(String id, String recipient, String messageContent) {
        this.id = id;
        this.recipient = recipient;
        this.messageContent = messageContent;
        this.status = "PENDING";
    }

    public String getRecipient() {
        return recipient;
    }
    public String getid(){
        return id;

    }
    public String getMessageContent(){
        return messageContent;
    }
    public String getStatus(){
        return status;
    }
    public void  setstatus(String status){
        this.status=status;

    }
}