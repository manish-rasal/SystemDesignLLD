package main.java.LLD.NotificationService;

public class EmailSender implements NotificationSender{

    @Override
    public void sendNotification() {
        System.out.println("We shall send an email");
    }
}
