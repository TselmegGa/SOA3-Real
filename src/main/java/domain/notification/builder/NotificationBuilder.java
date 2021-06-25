package domain.notification.builder;

import java.util.ArrayList;

public class NotificationBuilder {

    private final ArrayList<INotificationProvider> providers = new ArrayList<>();

    public NotificationBuilder addProvider(INotificationProvider provider){
        this.providers.add(provider);
        return this;
    }

    public Notification build(){
        return new Notification(this.providers);
    }

}
