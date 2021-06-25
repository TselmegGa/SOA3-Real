package domain.notification.builder;

import java.util.ArrayList;

public class Notification {

    private final ArrayList<INotificationProvider> providers;

    public Notification(ArrayList<INotificationProvider> providers) {
        this.providers = providers;
    }

    public void send(String subject, String message) {
        providers.forEach((p) -> p.send(subject, message));
    }

    @Override
    public String toString() {
        return "Notification{" +
                "providers=" + providers +
                '}';
    }
}
