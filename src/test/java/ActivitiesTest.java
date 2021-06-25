import domain.Activity;
import domain.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;


class ActivitiesTest {
    @Test
    void activitiesTest(){
        User bob = new User();
        User mike = new User();
        Activity activity = new Activity("Home page - Header",4, bob);

        activity.setDescription("Home page - Footer");
        activity.setValue(7);
        activity.setUser(mike);


        assertSame(activity.getDescription(), "Home page - Footer");
        assertSame(activity.getValue(), 7);
        assertSame(activity.getUser(), mike);
    }
}
