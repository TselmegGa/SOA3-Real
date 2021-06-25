import domain.*;
import domain.enums.ProjectRoles;
import domain.enums.SprintRoles;
import domain.forum.composit.Reaction;
import domain.forum.composit.Topic;
import domain.notification.builder.NotificationBuilder;
import domain.notification.builder.Providers.MailProvider;
import domain.notification.observer.Message;
import domain.templates.DotNetPipeline;
import domain.templates.NodeJSPipeline;
import domain.templates.PipelineTemplate;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class main {
    private static final Logger logger = LogManager.getLogger(User.class);
    public static void main(String[] args){

        Project project = new Project();


        //Create users
        User bob = new User();
        User charlie = new User();
        User dirk = new User();
        User bart = new User();
        bob.setAge(25);
        bob.setEmail("Bob@hotmail.com");
        bob.setName("Bob");
        Role role = new Role();
        role.setProjectRole(ProjectRoles.DEVELOPER);
        role.setSprintRole(SprintRoles.TESTER);
        bob.setRole(role);

        charlie.setAge(29);
        charlie.setEmail("charlie@hotmail.com");
        charlie.setName("charlie");
        role = new Role();
        role.setProjectRole(ProjectRoles.OWNER);
        role.setSprintRole(SprintRoles.NONE);
        charlie.setRole(role);

        dirk.setAge(28);
        dirk.setEmail("dirk@hotmail.com");
        dirk.setName("dirk");
        role = new Role();
        role.setProjectRole(ProjectRoles.SCRUMMASTER);
        role.setSprintRole(SprintRoles.DEVELOPER);
        dirk.setRole(role);

        dirk.setNotification(new NotificationBuilder()
                .addProvider(new MailProvider("dirk@gmail.com"))
//                .addProvider(new MailProvider("dirk@studentMail.nl"))
//                .addProvider(new DiscordProvider("6a204bd89f3c8348afd5c77c717a097a"))
                .build());

        bart.setAge(22);
        bart.setEmail("bart@hotmail.com");
        bart.setName("bart");
        role = new Role();
        role.setProjectRole(ProjectRoles.SCRUMMASTER);
        role.setSprintRole(SprintRoles.DEVELOPER);
        bart.setRole(role);

        bart.setNotification(new NotificationBuilder().addProvider(new MailProvider("bart@hotmail.com")).build());

        System.out.println(dirk.toString());

        Message message = new Message("Test Subject", "Dit is een test bericht ter controle");
        dirk.onNotification(message);
        charlie.onNotification(message);
        // Create items with State pattern
        Item item = new Item(4, project, "Main page");
        try
        {
            item.setUser(dirk);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        item.start();
        item.ready();
        item.test();
        item.done();
        //Create Project en voeg users toe
        project.setUsers(new User[]{bob, charlie, dirk, bart});

        //Template pattern
        PipelineTemplate template = new NodeJSPipeline(project, "Github","NodeJS Pipeline 1", "dir/js");
        PipelineTemplate template2 = new DotNetPipeline(project, "Azure",".NET Pipeline 2", true);
        template.run();

        //Time and Timezone
        Instant start = Instant.now();
        Instant end = Instant.now();
        end = end.plusMillis(10000);
        ZoneId centralEuropianTime = ZoneId.of("CET");
        ZonedDateTime startTime = ZonedDateTime.ofInstant(start, centralEuropianTime);
        ZonedDateTime endTime = ZonedDateTime.ofInstant(end, centralEuropianTime);

        //Create een Sprint with State pattern and Strategy pattern
        Sprint sprint = new Sprint(startTime, endTime);

        project.addSprint(sprint);
        sprint.run();
        while (sprint.timeRunning()){
            try
            {
                logger.info("The sprint is still running");
                Thread.sleep(2000);

            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
        }
        sprint.finish();
        sprint.release();
        sprint.getBehavior().planReview();
        sprint.close();

        Sprint sprint2 = new Sprint(startTime, endTime);

        project.addSprint(sprint2);
        sprint2.run();
        sprint2.finish();
        sprint2.annul();
        sprint2.getBehavior().planReview();
        sprint2.close();

        //Forum
        Topic topic = new Topic(charlie, new Item(4, project, "Main page"), "Java Compile error", "bij het compile krijg ik een fout melding");
        project.getForum().addTopic(topic);

        topic.addReaction(new Reaction(bob, "Heb je geen santex errors?"));
        topic.addReaction(new Reaction(dirk, "Intelij geeft geen errors"));
//        topic.addReaction(new Reaction(bob, "Dat is vreemd"));
        System.out.println(topic.toString());



        System.out.println("Done!");
    }


}
