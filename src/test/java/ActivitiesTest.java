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


        assertEquals(activity.getDescription(), "Home page - Footer");
        assertEquals(activity.getValue(), 7);
        assertEquals(activity.getUser(), mike);
    }
}
