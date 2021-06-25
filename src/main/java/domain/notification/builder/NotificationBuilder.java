package domain.notification.builder;

import java.util.ArrayList;
import java.util.List;

public class NotificationBuilder {

    private final List<INotificationProvider> providers = new ArrayList<>();

    public NotificationBuilder addProvider(INotificationProvider provider){
        this.providers.add(provider);
        return this;
    }

    public Notification build(){
        return new Notification(this.providers);
    }

}
