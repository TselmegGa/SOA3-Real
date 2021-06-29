package domain;

import domain.enums.ProjectRoles;
import domain.enums.SprintRoles;
import domain.forum.Forum;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Project {
    private static final Logger logger = LogManager.getLogger(Project.class);
    private String name;
    private List<Sprint> sprints;
    private Backlog backlog;
    private User[] users = new User[]{};
    private VersionControl versionControl;
    private Forum forum;

    public Project(List<Sprint> sprints, VersionControl vc, Backlog backlog, String name){
        this.versionControl = vc;
        this.sprints = sprints;
        this.backlog = backlog;
        this.forum = new Forum(this);
        this.name = name;
    }
    public Project(String name) {
        this(new ArrayList<>(),new VersionControl(), new Backlog(), name);
    }
    public Project(){
        this("Unnamed Project");
    }

    public User[] getUsers() {
        return users;
    }
    public User[] getDevelopers() {
        return Arrays.stream(users).filter(u -> u.getRole().getSprintRole() == SprintRoles.DEVELOPER ).toArray(size -> new User[size]);
    }
    public User[] getTesters() {
        return Arrays.stream(users).filter(u -> u.getRole().getSprintRole() == SprintRoles.TESTER ).toArray(size -> new User[size]);
    }
    public User[] getScrumMasters() {
        return Arrays.stream(users).filter(u -> u.getRole().getProjectRole()  == ProjectRoles.SCRUMMASTER ).toArray(size -> new User[size]);
    }
    public User[] getProductOwners() {
        return Arrays.stream(users).filter(u -> u.getRole().getProjectRole()  == ProjectRoles.OWNER ).toArray(size -> new User[size]);
    }


    public VersionControl getVersionControl() {
        return versionControl;
    }
    public List<Sprint> getSprints(){
        return sprints;
    }
    public Backlog getBacklog() {
        return backlog;
    }
    public Forum getForum() {
        return forum;
    }
    public String getName() {
        return name;
    }

    public void addSprint(Sprint sprint){
        if(noSprintRunning()){
            this.sprints.add(sprint);
            sprint.setProject(this);
        }
        else{
            logger.info("A Sprint is currently active");
            logger.info("Please close the sprint first");
        }
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setUsers(User[] users) {
        this.users = users;
    }
    public void setForum(Forum forum) {
        this.forum = forum;
    }

    private boolean noSprintRunning(){
        for (Sprint sprint: sprints) {
            if(!sprint.closed()){
                return false;
            }
        }
        return true;
    }
}