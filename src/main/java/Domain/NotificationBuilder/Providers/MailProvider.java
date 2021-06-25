package Domain.NotificationBuilder.Providers;

import Domain.NotificationBuilder.INotificationProvider;

public class MailProvider implements INotificationProvider {

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
