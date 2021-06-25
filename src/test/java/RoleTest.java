import Domain.Branch;
import Domain.Enum.ProjectRoles;
import Domain.Enum.SprintRoles;
import Domain.Role;
import Domain.VersionControl;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

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

        assertTrue(role.getProjectRole() == ProjectRoles.DEVELOPER);
        assertTrue(role.getSprintRole() == SprintRoles.TESTER);

    }

}
