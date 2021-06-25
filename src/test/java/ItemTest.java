import Domain.Activity;
import static org.mockito.Mockito.when;
import Domain.Item;
import Domain.Project;
import Domain.User;
import Infrastructure.ItemRepository;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {
    //Testcase 1 Backlog items
    //Backlog item can have activities or user but not both
    @Test

    void createItemWithActivities(){
        //arrange
        Project project = new Project();
        User bob = new User();
        ArrayList<Activity> activities = new ArrayList<>();
        activities.add(new Activity("UI - styling",3,bob));
        Item item = new Item(5, project, "Items Page");

        //act

        item.setValue(7);
        item.setActivities(activities);
        //assert
        assertTrue(item.getActivities() == activities );
        assertTrue(item.getValue() == 7 );
    }
    @Test
    void createItemWithUser(){
        //arrange
        Project project = new Project();
        User bob = new User();
        Item item = new Item(4, project, "Items Page");
        //act
        item.setUser(bob);
        //assert
        assertTrue(item.getUser() == bob );
        assertTrue(item.getValue() == 4 );
    }

    @Test
    void addingActivitiesToItemWithUserShouldFail(){
        //arrange
        Project project = new Project();
        User bob = new User();
        ArrayList<Activity> activities = new ArrayList<>();
        Item item = new Item(4, project, "Items Page");
        item.setUser(bob);
        //act
        // Cannot add activities if the item already has a user
        boolean result = item.setActivities(activities);
        //assert
        assertFalse(result);
    }

    @Test
    void addingUserToItemWithActivitiesShouldFail(){
        //arrange
        Project project = new Project();
        User bob = new User();
        ArrayList<Activity> activities = new ArrayList<>();
        activities.add(new Activity("UI - styling",3,bob));
        Item item = new Item(4, project ,"Items Page");
        item.setActivities(activities);
        //act
        // Cannot add user if the item already has activities
        boolean result = item.setUser(bob);
        //arrange
        assertFalse(result);
    }

}
