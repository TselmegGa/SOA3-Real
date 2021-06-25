package Domain.NotificationBuilder.Providers;

import Domain.NotificationBuilder.INotificationProvider;

public class DiscordProvider implements INotificationProvider {

    String key;

    public DiscordProvider(String key) {
        this.key = key;
    }

    @Override
    public void send(String subject, String message) {
        System.out.println("DiscordProvider Send: Message { Subject: " +  subject+ ", Message: " + message+ "} To key: " + this.key);
    }

    @Override
    public String toString() {
        return "DiscordProvider{" +
                "key='" + key + '\'' +
                '}';
    }
}
