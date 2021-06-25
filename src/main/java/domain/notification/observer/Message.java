package domain.notification.observer;

//Notification object
public class Message {
    private final String subject;
    private final String text;

    public String getSubject() {
        return subject;
    }

    public String getMessage() {
        return text;
    }

    public Message(String subject, String message) {
        this.subject = subject;
        this.text = message;
    }
}
