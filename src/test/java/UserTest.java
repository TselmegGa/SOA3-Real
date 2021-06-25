import Domain.Enum.ProjectRoles;
import Domain.Enum.SprintRoles;
import Domain.Role;
import Domain.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

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

        assertTrue(user.getRole()== role);
        assertTrue(user.getAge()== 45);
        assertTrue(user.getEmail()== "Mike@live.com");
        assertTrue(user.getName()== "Mike John");

    }
}
