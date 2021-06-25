package domain;

import domain.enums.ProjectRoles;
import domain.enums.SprintRoles;

public class Role {
    private ProjectRoles projectRole;
    private SprintRoles sprintRole;

    public Role() {
    }

    public Role(ProjectRoles projectRole, SprintRoles sprintRole) {
        this.projectRole = projectRole;
        this.sprintRole = sprintRole;
    }

    public ProjectRoles getProjectRole() {
        return projectRole;
    }

    public void setProjectRole(ProjectRoles projectRole) {
        this.projectRole = projectRole;
    }

    public SprintRoles getSprintRole() {
        return sprintRole;
    }

    public void setSprintRole(SprintRoles sprintRole) {
        this.sprintRole = sprintRole;
    }
}
