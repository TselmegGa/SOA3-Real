import domain.*;
import domain.forum.composit.Forum;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;


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

        assertEquals(project.getUsers()[0], user);
        assertEquals(project.getSprints().get(0), sprint);
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

        assertEquals(project.getSprints().get(0), sprint);
        assertEquals(2, project.getSprints().size());
        assertEquals(project.getVersionControl(), vc);
        assertEquals(project.getBacklog(), backlog);
    }
}
