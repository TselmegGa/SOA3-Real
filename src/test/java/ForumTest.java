import domain.enums.ProjectRoles;
import domain.enums.SprintRoles;
import domain.forum.composit.Reaction;
import domain.forum.composit.Topic;
import domain.Item;
import domain.Project;
import domain.Role;
import domain.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ForumTest {

    @Test
    void CreateTopicTest(){
        Role role = new Role(ProjectRoles.DEVELOPER, SprintRoles.DEVELOPER);
        User mike = new User("Mike Smith",role,44,"Mike@yahoo.com");

        User bart = new User("Bart van den zanden",role,23,"bart");
        Project project = new Project();
        project.setUsers(new User[]{mike, bart});

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
    }

    @Test
    void addReactionsToTopic(){
        Role role = new Role(ProjectRoles.DEVELOPER, SprintRoles.DEVELOPER);
        User mike = new User("Mike Smith",role,44,"Mike@yahoo.com");

        User bart = new User("Bart van den zanden",role,23,"bart");
        Project project = new Project();
        project.setUsers(new User[]{mike, bart});

        Item item = new Item(4, project, "Home Page");
        item.setUser(mike);

        Topic topic = new Topic(mike, item, "Test topic", "Ik loop vast... HELP");
        project.getForum().addTopic(topic);

        topic.addReaction(new Reaction(bart, "Even googlen"));
        topic.addReaction(new Reaction(mike, "Dat heb ik al gedaan"));


        assertEquals(2 , project.getForum().getTopics().get(0).getReactions().size());
        assertEquals(bart , project.getForum().getTopics().get(0).getReactions().get(0).getUser());
        assertEquals("Even googlen", project.getForum().getTopics().get(0).getReactions().get(0).getContent());


    }



}
