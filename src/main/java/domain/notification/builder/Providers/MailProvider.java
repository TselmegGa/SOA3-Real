package domain.notification.builder.Providers;

import domain.notification.builder.INotificationProvider;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class MailProvider implements INotificationProvider {
    private static final Logger logger = LogManager.getLogger(MailProvider.class);
    String to;

    public MailProvider(String to) {
        this.to = to;
    }


    @Override
    public void send(String subject, String message) {
        System.out.println("MailProvider Send: Message { Subject: " +  subject+ ", Message: " + message+ "} To: " + this.to);
    }

    @Override
    public String toString() {
        return "MailProvider{" +
                "to='" + to + '\'' +
                '}';
    }
}
