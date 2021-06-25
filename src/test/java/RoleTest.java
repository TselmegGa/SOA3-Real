import domain.enums.ProjectRoles;
import domain.enums.SprintRoles;
import domain.Role;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class RoleTest {
    @Test
    void RoleTest(){

        Role role = new Role();
        role.setProjectRole(ProjectRoles.SCRUMMASTER);
        role.setProjectRole(ProjectRoles.OWNER);
        role.setProjectRole(ProjectRoles.DEVELOPER);
        role.setSprintRole(SprintRoles.DEVELOPER);
        role.setSprintRole(SprintRoles.NONE);
        role.setSprintRole(SprintRoles.TESTER);

        assertEquals(role.getProjectRole(), ProjectRoles.DEVELOPER);
        assertEquals(role.getSprintRole(), SprintRoles.TESTER);

    }

}
