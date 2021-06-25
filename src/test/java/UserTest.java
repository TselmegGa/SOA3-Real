import domain.enums.ProjectRoles;
import domain.enums.SprintRoles;
import domain.Role;
import domain.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserTest {
    @Test
    void UserTest(){

        Role role = new Role();

        role.setProjectRole(ProjectRoles.DEVELOPER);

        role.setSprintRole(SprintRoles.TESTER);
        User user = new User("Mike Smith",role,44,"Mike@yahoo.com");
        role.setProjectRole(ProjectRoles.OWNER);
        user.setRole(role);
        user.setName("Mike John");
        user.setEmail("Mike@live.com");
        user.setAge(45);

        assertEquals(role, user.getRole());
        assertEquals(45, user.getAge());
        assertEquals("Mike@live.com", user.getEmail());
        assertEquals("Mike John", user.getName());

    }
}
