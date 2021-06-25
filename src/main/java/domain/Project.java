package domain;

import domain.enums.ProjectRoles;
import domain.enums.SprintRoles;
import domain.forum.composit.Forum;

import java.util.ArrayList;
import java.util.Arrays;


public class Project {
    private String name;
    private ArrayList<Sprint> sprints;
    private Backlog backlog;
    private User[] users = new User[]{};
    private VersionControl versionControl;
    private Forum forum;

    public Project(ArrayList<Sprint> sprints, VersionControl vc, Backlog backlog, String name){
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
        return (User[]) Arrays.stream(users).filter(u -> u.getRole().getSprintRole() == SprintRoles.DEVELOPER ).toArray(size -> new User[size]);
    }
    public User[] getTesters() {
        return (User[]) Arrays.stream(users).filter(u -> u.getRole().getSprintRole() == SprintRoles.TESTER ).toArray(size -> new User[size]);
    }
    public User[] getScrumMasters() {
        return (User[]) Arrays.stream(users).filter(u -> u.getRole().getProjectRole()  == ProjectRoles.SCRUMMASTER ).toArray(size -> new User[size]);
    }
    public User[] getProductOwners() {
        return (User[]) Arrays.stream(users).filter(u -> u.getRole().getProjectRole()  == ProjectRoles.OWNER ).toArray(size -> new User[size]);
    }


    public VersionControl getVersionControl() {
        return versionControl;
    }
    public ArrayList<Sprint> getSprints(){
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
        }
        else{
            System.out.println("A Sprint is currently active");
            System.out.println("Please close the sprint first");
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