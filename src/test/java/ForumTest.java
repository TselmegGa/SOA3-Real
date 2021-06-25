import domain.enums.ProjectRoles;
import domain.enums.SprintRoles;
import domain.forum.Reaction;
import domain.forum.Topic;
import domain.Item;
import domain.Project;
import domain.Role;
import domain.User;
import domain.notification.builder.NotificationBuilder;
import domain.notification.builder.providers.MailProvider;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ForumTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }


    @Test
    void CreateTopicTest(){
        Role role = new Role(ProjectRoles.DEVELOPER, SprintRoles.DEVELOPER);
        User mike = new User("Mike Smith",role,44,"Mike@yahoo.com");
        mike.setNotification(new NotificationBuilder().addProvider(new MailProvider("mike@yahoo.com")).build());

        User bart = new User("Bart van den zanden",role,23,"bart@yahoo.com");
        bart.setNotification(new NotificationBuilder().addProvider(new MailProvider("bart@yahoo.com")).build());

        Role roleMaster = new Role(ProjectRoles.SCRUMMASTER, SprintRoles.NONE);
        User sanne = new User("Sanne van der Linden",roleMaster,35,"Sanne@mail.com");
        sanne.setNotification(new NotificationBuilder().addProvider(new MailProvider("Sanne@mail.com")).build());

        Project project = new Project();
        project.setUsers(new User[]{mike, bart, sanne});

        Item item = new Item(4, project, "Home Page");
        item.setUser(mike);

        Topic topic = new Topic(mike, item, "Test topic", "Ik loop vast... HELP");
        project.getForum().addTopic(topic);


        assertEquals(topic, project.getForum().getTopics().get(0));
        assertEquals(1, project.getForum().getTopics().size() );

        assertEquals("Test topic", project.getForum().getTopics().get(0).getTitle());
        assertEquals("Ik loop vast... HELP", project.getForum().getTopics().get(0).getContent() );
        assertEquals(mike, project.getForum().getTopics().get(0).getStart() );
        assertEquals(item, project.getForum().getTopics().get(0).getItem() );
        assertEquals(0, project.getForum().getTopics().get(0).getReactions().size() );
        assertEquals("MailProvider Send: Message { Subject: Forum - Mike Smith opened: Test topic, Message: Ik loop vast... HELP} To: bart@yahoo.com",outputStreamCaptor.toString().trim());

        //
    }

    @Test
    void addReactionsToTopic(){
        Role role = new Role(ProjectRoles.DEVELOPER, SprintRoles.DEVELOPER);
        User mike = new User("Mike Smith",role,44,"Mike@yahoo.com");
        mike.setNotification(new NotificationBuilder().addProvider(new MailProvider("mike@yahoo.com")).build());

        User bart = new User("Bart van den zanden",role,23,"bart@yahoo.com");
        bart.setNotification(new NotificationBuilder().addProvider(new MailProvider("bart@yahoo.com")).build());

        Role roleMaster = new Role(ProjectRoles.SCRUMMASTER, SprintRoles.NONE);
        User sanne = new User("Sanne van der Linden",roleMaster,35,"Sanne@mail.com");
        sanne.setNotification(new NotificationBuilder().addProvider(new MailProvider("Sanne@mail.com")).build());

        Project project = new Project();
        project.setUsers(new User[]{mike, bart, sanne});

        Item item = new Item(4, project, "Home Page");
        item.setUser(mike);

        Topic topic = new Topic(mike, item, "Test topic", "Ik loop vast... HELP");
        project.getForum().addTopic(topic);

        topic.addReaction(new Reaction(bart, "Even googlen"));


        assertEquals(1 , project.getForum().getTopics().get(0).getReactions().size());
        assertEquals(bart , project.getForum().getTopics().get(0).getReactions().get(0).getUser());
        assertEquals("Even googlen", project.getForum().getTopics().get(0).getReactions().get(0).getContent());
        assertTrue(outputStreamCaptor.toString().trim().contains("MailProvider Send: Message { Subject: Forum - Test topic has an new reaction, Message: Bart van den zanden reacted with: Even googlen} To: mike@yahoo.com"));


    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }



}
