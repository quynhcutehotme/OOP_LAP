package OOP;

public class EmailService implements MessageSender {
    @Override
    public void send(String to, String message) {
        System.out.println("Sending EMAIL to " + to + ": " + message);
    }
}

interface MessageSender {
    void send(String to, String message);
}

class SmsService implements MessageSender {
    @Override
    public void send(String to, String message) {
        System.out.println("Sending SMS to " + to + ": " + message);
    }
}

class NotificationService {
    private final MessageSender sender;
    public NotificationService(MessageSender sender) {
        this.sender = sender;
    }
    public void sendWelcome(String to) {
        sender.send(to, "Welcome to our course!");
    }
}

class testMail {
    public static void main(String[] args) {
        NotificationService emailNotif = new NotificationService(new EmailService());
        emailNotif.sendWelcome("tin@example.com");
        NotificationService smsNotif = new NotificationService(new SmsService());
        smsNotif.sendWelcome("0123456789");
    }
}