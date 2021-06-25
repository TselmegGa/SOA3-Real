import domain.*;
import domain.enums.ProjectRoles;
import domain.enums.SprintRoles;

import domain.item.state.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ItemStateTest {
    //Testcase 7 Backlog Item states
    //TodoState
    @Test
    void itemWithTodoStateCanSwitchToDoingState(){
        //arrange
        Project project = new Project();
        User bob = new User();
        ArrayList<Activity> activities = new ArrayList<>();
        activities.add(new Activity("UI - styling",3,bob));
        Item item = new Item(activities,4, project, "About Pege");
        //act
        boolean result = item.start();
        IPhaseState state =  item.getState();
        //arrange
        assertTrue(result);
        assertEquals(state.getClass(), DoingState.class);
    }
    @Test
    void itemWithoutUserOrActivitiesCannotSwitchToDoingState(){
        Project project = new Project();
        //arrange
        Item item = new Item(4, project, "About Pege");

        //act
        boolean result = item.start();
        IPhaseState state =  item.getState();
        //arrange
        assertFalse(result);
        assertNotEquals(state.getClass(), DoingState.class);
    }
    @Test
    void itemWithTodoStateCannotSwitchToReadyForTestingState(){
        //arrange

        Project project = new Project();
        project.setUsers(new User[]{new User("Dirk", new Role(ProjectRoles.OWNER, SprintRoles.TESTER), 22, "dirk@gmail.com")});

        User bob = new User();
        ArrayList<Activity> activities = new ArrayList<>();
        activities.add(new Activity("UI - styling",3,bob));
        Item item = new Item(activities,4,project, "About Pege");

        //act

        boolean result = item.ready();
        IPhaseState state =  item.getState();
        //arrange
        assertFalse(result);
        assertNotEquals(state.getClass(), ReadyForTestingState.class);
    }
    @Test
    void itemWithTodoStateCannotSwitchToToDoState(){
        //arrange
        Project project = new Project();
        User bob = new User();
        ArrayList<Activity> activities = new ArrayList<>();
        activities.add(new Activity("UI - styling",3,bob));
        Item item = new Item(activities,4, project, "About Pege");

        //act

        boolean result = item.todo();

        //arrange
        assertFalse(result);

    }
    @Test
    void itemWithTodoStateCannotSwitchToTestingState(){
        //arrange
        Project project = new Project();
        User bob = new User();
        ArrayList<Activity> activities = new ArrayList<>();
        activities.add(new Activity("UI - styling",3,bob));
        Item item = new Item(activities,4, project, "About Pege");

        //act

        boolean result = item.test();
        IPhaseState state =  item.getState();
        //arrange
        assertFalse(result);
        assertNotEquals(state.getClass(), TestingState.class);
    }
    @Test
    void itemWithTodoStateCannotSwitchToDoneState(){
        //arrange
        Project project = new Project();
        User bob = new User();
        ArrayList<Activity> activities = new ArrayList<>();
        activities.add(new Activity("UI - styling",3,bob));
        Item item = new Item(activities,4, project, "About Pege");
        //act

        boolean result = item.done();
        IPhaseState state =  item.getState();
        //arrange
        assertFalse(result);
        assertNotEquals(state.getClass(), DoingState.class);
    }
    //Doing stat
    @Test
    void itemWithDoingStateCanSwitchToToDoState(){
        //arrange
        Project project = new Project();
        User bob = new User();
        ArrayList<Activity> activities = new ArrayList<>();
        activities.add(new Activity("UI - styling",3,bob));
        Item item = new Item(activities,4, project, "About Pege");
        item.start();
        //act
        boolean result = item.todo();
        IPhaseState state =  item.getState();
        //arrange
        assertTrue(result);
        assertEquals(state.getClass(), TodoState.class);
    }
    @Test
    void itemWithDoingStateCannotSwitchToDoingState(){
        //arrange
        Project project = new Project();
        User bob = new User();
        ArrayList<Activity> activities = new ArrayList<>();
        activities.add(new Activity("UI - styling",3,bob));
        Item item = new Item(activities,4, project, "About Pege");
        item.start();
        //act
        boolean result = item.start();
        IPhaseState state =  item.getState();
        //arrange
        assertFalse(result);
        assertNotEquals(state.getClass(), TodoState.class);
    }
    @Test
    void itemWithDoingCannotSwitchToReadyForTestingState(){
        //arrange
        Project project = new Project();
        User bob = new User("bob", new Role(ProjectRoles.OWNER, SprintRoles.TESTER), 25, "bob@gmail.com" );
        project.setUsers(new User[]{bob});

        ArrayList<Activity> activities = new ArrayList<>();
        activities.add(new Activity("UI - styling",3,bob));
        Item item = new Item(activities,4,project, "About Pege");
        item.start();
        //act
        boolean result = item.ready();
        IPhaseState state =  item.getState();
        //arrange
        assertTrue(result);
        assertEquals(state.getClass(), ReadyForTestingState.class);
    }
    @Test
    void itemWithDoingStateCannotSwitchToTestingState(){
        //arrange
        Project project = new Project();
        User bob = new User();
        ArrayList<Activity> activities = new ArrayList<>();
        activities.add(new Activity("UI - styling",3,bob));
        Item item = new Item(activities,4, project, "About Pege");
        item.start();
        //act
        boolean result = item.test();
        IPhaseState state =  item.getState();
        //arrange
        assertFalse(result);
        assertNotEquals(state.getClass(), TestingState.class);
    }
    @Test
    void itemWithDoingStateCannotSwitchToDoneState(){
        //arrange
        Project project = new Project();
        User bob = new User();
        ArrayList<Activity> activities = new ArrayList<>();
        activities.add(new Activity("UI - styling",3,bob));
        Item item = new Item(activities,4, project, "About Pege");
        item.start();
        //act
        boolean result = item.done();
        IPhaseState state =  item.getState();
        //arrange
        assertFalse(result);
        assertNotEquals(state.getClass(), DoneState.class);
    }
    //Ready For Testing State
    @Test
    void itemWithReadyForTestingStateCanSwitchToToDoState(){
        //arrange
        Project project = new Project();
        User bob = new User();
        ArrayList<Activity> activities = new ArrayList<>();
        activities.add(new Activity("UI - styling",3,bob));
        Item item = new Item(activities,4, project, "About Pege");
        item.start();
        item.ready();
        //act
        boolean result = item.todo();
        IPhaseState state =  item.getState();
        //arrange
        assertTrue(result);
        assertEquals(state.getClass(), TodoState.class);
    }


    @Test
    void itemWithReadyForTestingStateCannotSwitchToDoingState(){
        //arrange
        Project project = new Project();
        User bob = new User();
        ArrayList<Activity> activities = new ArrayList<>();
        activities.add(new Activity("UI - styling",3,bob));
        Item item = new Item(activities,4,project, "About Pege");
        item.start();
        item.ready();
        //act
        boolean result = item.start();
        IPhaseState state =  item.getState();
        //arrange
        assertFalse(result);
        assertNotEquals(state.getClass(), DoingState.class);
    }
    @Test
    void itemWithReadyForTestingStateCannotSwitchToReadyForTestingState(){
        //arrange
        Project project = new Project();
        User bob = new User();
        ArrayList<Activity> activities = new ArrayList<>();
        activities.add(new Activity("UI - styling",3,bob));
        Item item = new Item(activities,4, project, "About Pege");
        item.start();
        item.ready();
        //act
        boolean result = item.ready();
        //arrange
        assertFalse(result);
    }
    @Test
    void itemWithReadyForTestingStateCanSwitchToTestingState(){
        //arrange
        Project project = new Project();
        User bob = new User();
        ArrayList<Activity> activities = new ArrayList<>();
        activities.add(new Activity("UI - styling",3,bob));
        Item item = new Item(activities,4, project, "About Pege");
        item.start();
        item.ready();
        //act
        boolean result = item.test();
        IPhaseState state =  item.getState();
        //arrange
        assertTrue(result);
        assertEquals(state.getClass(), TestingState.class);
    }
    @Test
    void itemWithReadyForTestingStateCannotSwitchToDoneState(){
        //arrange
        Project project = new Project();
        User bob = new User();
        ArrayList<Activity> activities = new ArrayList<>();
        activities.add(new Activity("UI - styling",3,bob));
        Item item = new Item(activities,4, project, "About Pege");
        item.start();
        item.ready();
        //act
        boolean result = item.done();
        IPhaseState state =  item.getState();
        //arrange
        assertFalse(result);
        assertNotEquals(state.getClass(), DoneState.class);
    }
    //Testing State
    @Test
    void itemWithTestingStateCanSwitchToToDoState(){
        //arrange
        Project project = new Project();
        User bob = new User();
        ArrayList<Activity> activities = new ArrayList<>();
        activities.add(new Activity("UI - styling",3,bob));
        Item item = new Item(activities,4, project, "About Pege");
        item.start();
        item.ready();
        item.test();
        //act
        boolean result = item.todo();
        IPhaseState state =  item.getState();
        //arrange
        assertTrue(result);
        assertEquals(state.getClass(), TodoState.class);
    }
    @Test
    void itemWithTestingStateCannotSwitchToDoingState(){
        //arrange
        Project project = new Project();
        User bob = new User();
        ArrayList<Activity> activities = new ArrayList<>();
        activities.add(new Activity("UI - styling",3,bob));
        Item item = new Item(activities,4, project, "About Pege");
        item.start();
        item.ready();
        item.test();
        //act
        boolean result = item.start();
        IPhaseState state =  item.getState();
        //arrange
        assertFalse(result);
        assertNotEquals(state.getClass(), DoingState.class);
    }
    @Test
    void itemWithTestingStateCannotSwitchToReadyForTestingState(){
        //arrange
        Project project = new Project();
        User bob = new User();
        ArrayList<Activity> activities = new ArrayList<>();
        activities.add(new Activity("UI - styling",3,bob));
        Item item = new Item(activities,4, project, "About Pege");
        item.start();
        item.ready();
        item.test();
        //act
        boolean result = item.ready();
        IPhaseState state =  item.getState();
        //arrange
        assertFalse(result);
        assertNotEquals(state.getClass(), ReadyForTestingState.class);
    }
    @Test
    void itemWithTestingStateCannotSwitchToTestingState(){
        //arrange
        Project project = new Project();
        User bob = new User();
        ArrayList<Activity> activities = new ArrayList<>();
        activities.add(new Activity("UI - styling",3,bob));
        Item item = new Item(activities,4, project, "About Pege");
        item.start();
        item.ready();
        item.test();
        //act
        boolean result = item.test();

        //arrange
        assertFalse(result);

    }
    @Test
    void itemWithTestingStateCanSwitchToDoneState(){
        //arrange
        Project project = new Project();
        User bob = new User();
        ArrayList<Activity> activities = new ArrayList<>();
        activities.add(new Activity("UI - styling",3,bob));
        Item item = new Item(activities,4, project, "About Pege");
        item.start();
        item.ready();
        item.test();
        //act
        boolean result = item.done();
        IPhaseState state =  item.getState();
        //arrange
        assertTrue(result);
        assertEquals(state.getClass(), DoneState.class);
    }
    //Done State
    @Test
    void itemWithDoneStateCannotSwitchToToDoState(){
        //arrange
        Project project = new Project();
        User bob = new User();
        ArrayList<Activity> activities = new ArrayList<>();
        activities.add(new Activity("UI - styling",3,bob));
        Item item = new Item(activities,4, project, "About Pege");
        item.start();
        item.ready();
        item.test();
        item.done();
        //act
        boolean result = item.todo();
        IPhaseState state =  item.getState();
        //arrange
        assertFalse(result);
        assertNotEquals(state.getClass(), TodoState.class);
    }
    @Test
    void itemWithDoneStateCannotSwitchToDoingState(){
        //arrange
        Project project = new Project();
        User bob = new User();
        ArrayList<Activity> activities = new ArrayList<>();
        activities.add(new Activity("UI - styling",3,bob));
        Item item = new Item(activities,4, project, "About Pege");
        item.start();
        item.ready();
        item.test();
        item.done();
        //act
        boolean result = item.start();
        IPhaseState state =  item.getState();
        //arrange
        assertFalse(result);
        assertNotEquals(state.getClass(), DoingState.class);
    }
    @Test
    void itemWithDoneStateCanSwitchToReadyForTestingState(){
        //arrange
        Project project = new Project();
        User bob = new User();
        ArrayList<Activity> activities = new ArrayList<>();
        activities.add(new Activity("UI - styling",3,bob));
        Item item = new Item(activities,4, project, "About Pege");
        item.start();
        item.ready();
        item.test();
        item.done();
        //act
        boolean result = item.ready();
        IPhaseState state =  item.getState();
        //arrange
        assertTrue(result);
        assertEquals(state.getClass(), ReadyForTestingState.class);
    }
    @Test
    void itemWithDoneStateCannotSwitchToTestingState(){
        //arrange
        Project project = new Project();
        User bob = new User();
        ArrayList<Activity> activities = new ArrayList<>();
        activities.add(new Activity("UI - styling",3,bob));
        Item item = new Item(activities,4, project, "About Pege");
        item.start();
        item.ready();
        item.test();
        item.done();
        //act
        boolean result = item.test();
        IPhaseState state =  item.getState();
        //arrange
        assertFalse(result);
        assertNotEquals(state.getClass(), TestingState.class);
    }
    @Test
    void itemWithDoneStateCannotSwitchToDoneState(){
        //arrange
        Project project = new Project();
        User bob = new User();
        ArrayList<Activity> activities = new ArrayList<>();
        activities.add(new Activity("UI - styling",3,bob));
        Item item = new Item(activities,4, project, "About Pege");
        item.start();
        item.ready();
        item.test();
        item.done();
        //act
        boolean result = item.done();

        //arrange
        assertFalse(result);

    }

}
