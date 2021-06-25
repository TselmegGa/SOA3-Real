import domain.*;
import domain.forum.composit.Forum;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ProjectTest {
    @Test
    void ProjectTest(){
        Instant start = Instant.now();
        Instant end = Instant.now();
        end = end.plusMillis(1000);
        ZoneId centralEuropianTime = ZoneId.of("CET");
        ZonedDateTime startTime = ZonedDateTime.ofInstant(start, centralEuropianTime);
        ZonedDateTime endTime = ZonedDateTime.ofInstant(end, centralEuropianTime);
        Project project = new Project();
        Role role = new Role();
        User user = new User("Mike Smith",role,44,"Mike@yahoo.com");
        Sprint sprint = new Sprint(startTime,endTime,project);
        User[] users = {user};
        project.setUsers(users);
        project.addSprint(sprint);

        assertTrue(project.getUsers()[0]== user);
        assertTrue(project.getSprints().get(0) == sprint);
    }
    @Test
    void ProjectWithConstucterTest(){

        Instant start = Instant.now();
        Instant end = Instant.now();
        end = end.plusMillis(1000);
        ZoneId centralEuropianTime = ZoneId.of("CET");
        ZonedDateTime startTime = ZonedDateTime.ofInstant(start, centralEuropianTime);
        ZonedDateTime endTime = ZonedDateTime.ofInstant(end, centralEuropianTime);
        Sprint sprint = new Sprint(startTime,endTime);
        Sprint sprint2 = new Sprint(startTime,endTime);
        ArrayList<Sprint> sprints = new ArrayList<>();
        sprint.annul();

        sprint.close();
        sprints.add(sprint);
        sprints.add(sprint2);

        VersionControl vc = new VersionControl();
        Backlog backlog = new Backlog();

        Project project = new Project(sprints,vc,backlog, "MoneyMan Project");
        Forum forum = new Forum(project);
        project.addSprint(sprint);
        project.setForum(forum);

        assertTrue(project.getSprints().get(0) == sprint);
        assertSame(project.getSprints().size() ,2);
        assertTrue(project.getVersionControl() == vc);
        assertTrue(project.getBacklog() == backlog);
    }
}
