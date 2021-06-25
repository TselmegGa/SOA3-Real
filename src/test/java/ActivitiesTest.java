import domain.Activity;
import domain.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ActivitiesTest {
    @Test
    void activitiesTest(){
        User bob = new User();
        User mike = new User();
        Activity activity = new Activity("Home page - Header",4, bob);

        activity.setDescription("Home page - Footer");
        activity.setValue(7);
        activity.setUser(mike);


        assertTrue(activity.getDescription() == "Home page - Footer");
        assertTrue(activity.getValue() == 7);
        assertTrue(activity.getUser() == mike);
    }
}
