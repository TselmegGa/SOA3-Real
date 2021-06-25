package domain.notification.observer;

//Observer luisterd naar update dus in dit geval notificaites
public abstract class NotificationObserver {
    public abstract void onNotification(Message message);
}
