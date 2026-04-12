package main.java.LLD.NotificationService;

public class SMSSender implements NotificationSender {
    @Override
    public void sendNotification() {
        System.out.println("We are going to send SMS");
    }
}
