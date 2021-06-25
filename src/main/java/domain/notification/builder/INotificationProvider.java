package domain.notification.builder;

public interface INotificationProvider {
    void send(String subject, String message);
}
