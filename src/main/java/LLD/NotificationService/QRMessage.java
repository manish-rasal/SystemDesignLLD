package main.java.LLD.NotificationService;

public class QRMessage extends Notification {

    public QRMessage(NotificationSender notificationSender) {
        super(notificationSender);
        System.out.println("This is a QR code");
    }

    @Override
    void sendMessage() {
        notificationSender.sendNotification();
    }
}
