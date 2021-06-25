import domain.Activity;
import domain.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class ActivitiesTest {
    @Test
    void activitiesTest(){
        User bob = new User();
        User mike = new User();
        Activity activity = new Activity("Home page - Header",4, bob);

        activity.setDescription("Home page - Footer");
        activity.setValue(7);
        activity.setUser(mike);


        assertEquals( "Home page - Footer", activity.getDescription());
        assertEquals(7, activity.getValue());
        assertEquals(activity.getUser(), mike);
    }
}
