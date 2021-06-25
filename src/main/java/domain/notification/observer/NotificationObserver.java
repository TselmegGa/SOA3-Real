package domain.notification.observer;

//Observer luisterd naar update dus in dit geval notificaites
public interface NotificationObserver {
    void onNotification(Message message);
}
