package domain.notification.builder.Providers;

import domain.notification.builder.INotificationProvider;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class DiscordProvider implements INotificationProvider {
    private static final Logger logger = LogManager.getLogger(DiscordProvider.class);
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
