import domain.*;
import domain.behavior.DeploymentReviewBehavior;
import domain.behavior.FinishedBehavior;
import domain.behavior.NormalReviewBehavior;

import domain.sprint.state.*;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.*;

class SprintStateTest {
    @Test
    void SprintWithNewSprintStateCanSwitchToRunningState(){
        Instant start = Instant.now();
        Instant end = Instant.now();
        end = end.plusMillis(10000);
        ZoneId centralEuropianTime = ZoneId.of("CET");
        ZonedDateTime startTime = ZonedDateTime.ofInstant(start, centralEuropianTime);
        ZonedDateTime endTime = ZonedDateTime.ofInstant(end, centralEuropianTime);
        Sprint sprint = new Sprint(startTime, endTime);

        sprint.run();
        SprintState result = sprint.getState();

        assertSame(result.getClass() , RunningState.class);
    }
    @Test
    void SprintWithNewSprintStateCanSwitchToAnnulledState(){
        Instant start = Instant.now();
        Instant end = Instant.now();
        end = end.plusMillis(10000);
        ZoneId centralEuropianTime = ZoneId.of("CET");
        ZonedDateTime startTime = ZonedDateTime.ofInstant(start, centralEuropianTime);
        ZonedDateTime endTime = ZonedDateTime.ofInstant(end, centralEuropianTime);
        Sprint sprint = new Sprint(startTime, endTime);

        sprint.annul();
        SprintState result = sprint.getState();

        assertSame(result.getClass(), AnnulledState.class);
    }
    @Test
    void SprintWithNewSprintStateCannotSwitchToSomeState(){
        Instant start = Instant.now();
        Instant end = Instant.now();
        end = end.plusMillis(10000);
        ZoneId centralEuropianTime = ZoneId.of("CET");
        ZonedDateTime startTime = ZonedDateTime.ofInstant(start, centralEuropianTime);
        ZonedDateTime endTime = ZonedDateTime.ofInstant(end, centralEuropianTime);
        Sprint sprint = new Sprint(startTime, endTime);
        //closed ,released, finished
        sprint.close();
        SprintState result = sprint.getState();

        assertSame(result.getClass(), ClosedState.class);
    }
    @Test
    void SprintWithRunningStateCannotSwitchToAnnulledState(){
        Instant start = Instant.now();
        Instant end = Instant.now();
        end = end.plusMillis(10000);
        ZoneId centralEuropianTime = ZoneId.of("CET");
        ZonedDateTime startTime = ZonedDateTime.ofInstant(start, centralEuropianTime);
        ZonedDateTime endTime = ZonedDateTime.ofInstant(end, centralEuropianTime);
        Sprint sprint = new Sprint(startTime, endTime);
        sprint.run();

        sprint.annul();
        SprintState result = sprint.getState();

        assertSame(result.getClass(), AnnulledState.class);
    }
    @Test
    void SprintWithRunningStateCanSwitchToFinishedState(){
        Instant start = Instant.now();
        Instant end = Instant.now();
        end = end.plusMillis(10000);
        ZoneId centralEuropianTime = ZoneId.of("CET");
        ZonedDateTime startTime = ZonedDateTime.ofInstant(start, centralEuropianTime);
        ZonedDateTime endTime = ZonedDateTime.ofInstant(end, centralEuropianTime);
        Sprint sprint = new Sprint(startTime, endTime);
        sprint.run();

        sprint.finish();
        SprintState result = sprint.getState();

        assertSame(result.getClass(), FinishedState.class);
    }
    @Test
    void SprintWithRunningStateCannotSwitchToSomeState(){
        Instant start = Instant.now();
        Instant end = Instant.now();
        end = end.plusMillis(10000);
        ZoneId centralEuropianTime = ZoneId.of("CET");
        ZonedDateTime startTime = ZonedDateTime.ofInstant(start, centralEuropianTime);
        ZonedDateTime endTime = ZonedDateTime.ofInstant(end, centralEuropianTime);
        Sprint sprint = new Sprint(startTime, endTime);
        sprint.run();

        //closed ,released, running
        sprint.release();
        SprintState result = sprint.getState();

        assertSame(result.getClass(), ReleasedState.class);
    }
    @Test
    void SprintWithFinishedStateCanSwitchToReleasedState(){
        Instant start = Instant.now();
        Instant end = Instant.now();
        end = end.plusMillis(10000);
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
        sprint.run();
        sprint.finish();

        sprint.release();
        SprintState result = sprint.getState();

        assertSame(result.getClass(), ReleasedState.class);
    }
    @Test
    void SprintWithFinishedStateCanSwitchToAnnulledState(){
        Instant start = Instant.now();
        Instant end = Instant.now();
        end = end.plusMillis(10000);
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
        sprint.run();
        sprint.finish();

        sprint.annul();
        SprintState result = sprint.getState();

        assertSame(result.getClass(), AnnulledState.class);
    }
    @Test
    void SprintWithFinishedStateCanSwitchToSomeState(){
        Instant start = Instant.now();
        Instant end = Instant.now();
        end = end.plusMillis(10000);
        ZoneId centralEuropianTime = ZoneId.of("CET");
        ZonedDateTime startTime = ZonedDateTime.ofInstant(start, centralEuropianTime);
        ZonedDateTime endTime = ZonedDateTime.ofInstant(end, centralEuropianTime);
        Sprint sprint = new Sprint(startTime, endTime);
        sprint.run();
        sprint.finish();

        //closed ,finished, running
        sprint.run();
        SprintState result = sprint.getState();

        assertSame(result.getClass(), RunningState.class);
    }
    @Test
    void SprintWithReleasedStateCanSwitchToClosedState(){
        Instant start = Instant.now();
        Instant end = Instant.now();
        end = end.plusMillis(10000);
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
        sprint.run();
        sprint.finish();
        sprint.release();

        sprint.close();
        SprintState result = sprint.getState();

        assertSame(result.getClass(), ClosedState.class);
    }
    @Test
    void SprintWithReleasedStateCannotSwitchToSomeState(){
        Instant start = Instant.now();
        Instant end = Instant.now();
        end = end.plusMillis(10000);
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
        sprint.run();
        sprint.finish();
        sprint.release();

        //released ,finished, running, annulled
        sprint.annul();
        SprintState result = sprint.getState();

        assertSame(result.getClass(), AnnulledState.class);
    }
    @Test
    void SprintWithAnnulledStateCanSwitchToClosedState(){
        Instant start = Instant.now();
        Instant end = Instant.now();
        end = end.plusMillis(10000);
        ZoneId centralEuropianTime = ZoneId.of("CET");
        ZonedDateTime startTime = ZonedDateTime.ofInstant(start, centralEuropianTime);
        ZonedDateTime endTime = ZonedDateTime.ofInstant(end, centralEuropianTime);
        Sprint sprint = new Sprint(startTime, endTime);


        sprint.annul();

        sprint.close();
        SprintState result = sprint.getState();

        assertSame(result.getClass(), ClosedState.class);
    }
    @Test
    void SprintWithAnnulledStateCannotSwitchToSomeState(){
        Instant start = Instant.now();
        Instant end = Instant.now();
        end = end.plusMillis(10000);
        ZoneId centralEuropianTime = ZoneId.of("CET");
        ZonedDateTime startTime = ZonedDateTime.ofInstant(start, centralEuropianTime);
        ZonedDateTime endTime = ZonedDateTime.ofInstant(end, centralEuropianTime);
        Sprint sprint = new Sprint(startTime, endTime);


        sprint.annul();

        //released ,finished, running, annulled
        sprint.finish();
        SprintState result = sprint.getState();

        assertSame(result.getClass(), FinishedState.class);
    }
    @Test
    void SprintWithReleasedStateCanGetDeploymentBehavior(){
        Instant start = Instant.now();
        Instant end = Instant.now();
        end = end.plusMillis(10000);
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
        sprint.run();
        sprint.finish();
        sprint.release();

        FinishedBehavior result =sprint.getBehavior();
        result.planReview();

        assertSame(result.getClass(), DeploymentReviewBehavior.class);
    }
    @Test
    void SprintWithAnulledStateFromFinishedStateCanGetNormalBehavior(){
        Instant start = Instant.now();
        Instant end = Instant.now();
        end = end.plusMillis(10000);
        ZoneId centralEuropianTime = ZoneId.of("CET");
        ZonedDateTime startTime = ZonedDateTime.ofInstant(start, centralEuropianTime);
        ZonedDateTime endTime = ZonedDateTime.ofInstant(end, centralEuropianTime);
        Sprint sprint = new Sprint(startTime, endTime);
        sprint.run();
        sprint.finish();
        sprint.annul();

        FinishedBehavior result = sprint.getBehavior();
        result.planReview();

        assertSame(result.getClass(), NormalReviewBehavior.class);
    }
}
