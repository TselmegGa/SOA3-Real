package domain.notification.observer;

import java.util.ArrayList;
import java.util.List;

// een standaard implementatie van NotificationSubject
// Dit omdat we het op meerdere plekken gaan gebruiken en het niet logish is om telkens dezelfde implementie opnieuw te schrijven.
public class BasicNotificationSubject implements NotificationSubject {
    private List<NotificationObserver> listeners = new ArrayList<>();

    @Override
    public void registerNotificationObserver(NotificationObserver notificationObserver) {
        //Voor kom duplicateds
        if(!this.listeners.contains(notificationObserver)){
            listeners.add(notificationObserver);
        }
    }

    @Override
    public void registerNotificationObserver(NotificationObserver[] notificationObserver) {
        //Voor kom duplicateds
        for (var i = 0; i < notificationObserver.length; i++) {
            if(!this.listeners.contains(notificationObserver[i])){
                listeners.add(notificationObserver[i]);
            }
        }
    }

    @Override
    public void removeNotificationObserver(NotificationObserver notificationObserver) {
        listeners.remove(notificationObserver);
    }

    @Override
    public void notifyNotificationObserver(Message message) {
        listeners.forEach((notificationObserver -> notificationObserver.onNotification(message)));
    }



}
