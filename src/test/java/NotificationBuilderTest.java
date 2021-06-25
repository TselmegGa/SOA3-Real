import domain.notification.builder.INotificationProvider;
import domain.notification.builder.Notification;
import domain.notification.builder.NotificationBuilder;
import domain.notification.builder.Providers.DiscordProvider;
import domain.notification.builder.Providers.MailProvider;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class NotificationBuilderTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void notificationBuilderTest(){

        INotificationProvider mailProvider = new MailProvider("student@avans.nl");
        INotificationProvider discordProvider = new DiscordProvider("1fc93908a9403d61fbf587381dac002b");
        ArrayList<INotificationProvider> providers = new ArrayList<>();
        providers.add(mailProvider);
        providers.add(discordProvider);


        Notification notificationFromBuilder = new NotificationBuilder().addProvider(mailProvider).addProvider(discordProvider).build();
        Notification notificationFromConstructor = new Notification(providers);

        assertEquals(notificationFromBuilder.toString(), notificationFromConstructor.toString());

    }

    @Test
    void  notificationSendTest(){
        INotificationProvider mailProvider = new MailProvider("student@avans.nl");
        INotificationProvider discordProvider = new DiscordProvider("1fc93908a9403d61fbf587381dac002b");
        Notification notificationFromBuilder = new NotificationBuilder().addProvider(mailProvider).addProvider(discordProvider).build();

        notificationFromBuilder.send("Test onderwerp", "Test bericht");

        assertTrue(outputStreamCaptor.toString().trim().contains("MailProvider Send: Message { Subject: Test onderwerp, Message: Test bericht} To: student@avans.nl"));
        assertTrue(outputStreamCaptor.toString().trim().contains("DiscordProvider Send: Message { Subject: Test onderwerp, Message: Test bericht} To key: 1fc93908a9403d61fbf587381dac002b"));

    }

//    @Test
//    void setNotificationOnUser(){
//        INotificationProvider mailProvider = new MailProvider("student@avans.nl");
//        INotificationProvider discordProvider = new DiscordProvider("1fc93908a9403d61fbf587381dac002b");
//
//
//
//        Role role = new Role(ProjectRoles.DEVELOPER, SprintRoles.DEVELOPER);
//        User mike = new User("Mike Smith",role,44,"Mike@yahoo.com");
//        mike.setNotification(new NotificationBuilder()
//                .addProvider(mailProvider)
//                .addProvider(discordProvider)
//                .build());
//
//        mike.
//
//
//    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}
