package domain.notification.observer;

//Notification object
public class Message {
    private final String subject, message;

    public String getSubject() {
        return subject;
    }

    public String getMessage() {
        return message;
    }

    public Message(String subject, String message) {
        this.subject = subject;
        this.message = message;
    }
}
