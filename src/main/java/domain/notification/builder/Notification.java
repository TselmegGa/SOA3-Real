package domain.notification.builder;

import java.util.List;

public class Notification {

    private final List<INotificationProvider> providers;

    public Notification(List<INotificationProvider> providers) {
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
