package main.java.LLD.NotificationService;

public class BridgeMain {
    public static void main(String[] args) {
        TextMessage textMessage = new TextMessage(new SMSSender());
        textMessage.sendMessage();

        QRMessage qrMessage = new QRMessage(new EmailSender());
        qrMessage.sendMessage();
    }
}
