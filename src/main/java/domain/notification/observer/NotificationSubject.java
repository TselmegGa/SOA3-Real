package domain.notification.observer;

//De Subject is de verzender, dus bij hier moeten ze ook geregisteerd worden
public interface NotificationSubject {
    void registerNotificationObserver(NotificationObserver notificationObserver);
    void registerNotificationObserver(NotificationObserver[] notificationObserver);
    void removeNotificationObserver(NotificationObserver notificationObserver);
    void notifyNotificationObserver(Message message);
//    void notifyNotificationObserverExcept(Message message, NotificationObserver... notificationObservers);
}
