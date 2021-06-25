package Domain.NotificationBuilder;

public interface INotificationProvider {
    void send(String subject, String message);
}
